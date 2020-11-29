package practice10;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

public class Teacher extends Person implements Observer {
    private LinkedList<Klass> classes;

    public Teacher(Integer id, String name, int age) {
        super(id, name, age);
        this.classes = new LinkedList<>();
    }

    public Teacher(Integer id, String name, int age, LinkedList<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        this.registerClasses(classes);
    }

    private void registerClasses(LinkedList<Klass> classes) {
        classes.forEach(klass -> klass.addObserver(this));
    }

    public List<Klass> getClasses() {
        return this.classes;
    }

    @Override
    public String introduce() {
        return String.format("%s I am a Teacher. I teach %s.", super.introduce(), (classes.size() == 0 ? "No Class" : "Class " + classes.stream().map(klass -> klass.getNumber().toString()).collect(Collectors.joining(", "))));
    }

    public String introduceWith(Student student) {
        return String.format("%s I am a Teacher. I%s teach %s.", super.introduce(), (this.isTeaching(student) ? "" : " don't"), student.getName());
    }

    public boolean isTeaching(Student student) {
        return this.classes.stream().anyMatch(klass -> klass.getNumber().equals(student.getKlass().getNumber()));
    }

    @Override
    public void update(Observable observable, Object o) {
        switch (((Klass) observable).getEvent()) {
            case APPEND_MEMBER:
                System.out.printf("I am %s. I know %s has joined %s.\n", super.getName(), ((Student) o).getName(), ((Klass) observable).getDisplayName());
                break;
            case ASSIGN_LEADER:
                System.out.printf("I am %s. I know %s become Leader of %s.\n", super.getName(), ((Student) o).getName(), ((Klass) observable).getDisplayName());
                break;
        }
    }
}
