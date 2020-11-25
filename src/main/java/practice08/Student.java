package practice08;

public class Student extends Person{
    private Klass klass;

    public Student(Integer id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() { return klass; }

    @Override
    public String introduce() {
        String message = "I am at " + klass.getDisplayName();

        Student leader = this.klass.getLeader();
        if(leader != null && leader.getId().equals(super.getId())) {
            message = "I am Leader of " + klass.getDisplayName();
        }

        return  super.introduce() + " I am a Student. " + message + ".";
    }
}
