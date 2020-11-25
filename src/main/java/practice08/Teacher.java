package practice08;

public class Teacher extends Person{
    private Klass klass;

    public Teacher(Integer id, String name, int age) {
        super(id, name, age);
        this.klass = null;
    }

    public Teacher(Integer id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() { return klass; }

    @Override
    public String introduce() {
        return  super.introduce() + " I am a Teacher. " + (klass == null ? "I teach No Class." : "I teach " + klass.getDisplayName() + ".") ;
    }

    public String introduceWith(Student student) {
        return super.introduce() + " I am a Teacher. I" + (student.getKlass().getNumber().equals(this.klass.getNumber()) ? "" : " don't") + " teach " + student.getName() + ".";
    }
}
