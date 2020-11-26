package practice10;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;

public class Teacher extends Person implements PractiseObserver {
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

    private void registerClasses(LinkedList<Klass> classes) { classes.stream().forEach(klass -> klass.addObserver(this)); }

    public List<Klass> getClasses() { return classes; }

    @Override
    public String introduce() {
        return  super.introduce() + " I am a Teacher. " + (classes.size() == 0 ? "I teach No Class." : "I teach Class " + classes.stream().map(klass -> klass.getNumber().toString()).collect(Collectors.joining(", ")) + ".") ;
    }

    public String introduceWith(Student student) {
        return super.introduce() + " I am a Teacher. I" + (this.isTeaching(student) ? "" : " don't") + " teach " + student.getName() + ".";
    }

    public boolean isTeaching(Student student) {
        return this.classes.stream().anyMatch(klass -> klass.getNumber().equals(student.getKlass().getNumber())) ;
    }

    @Override
    public void notifyForAction(Observable observable, Object o, String actionType) {
        if(observable == null || o == null || actionType.isEmpty()) {
            return;
        }

        Klass klass = (Klass) observable;
        Student student = (Student) o ;

        if(actionType.equals("appendMember")) {
            System.out.print("I am " + super.getName() + ". I know " + student.getName() + " has joined " + klass.getDisplayName() + ".\n");
        }
        else if(actionType.equals("assignLeader")) {
            System.out.print("I am " + super.getName() + ". I know " + student.getName() + " become Leader of " + klass.getDisplayName() + ".\n");
        }
    }
}
