package practice10;

public class Student extends Person {
    private Klass klass;

    public Student(Integer id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
        klass.appendMember(this);
    }

    public Klass getKlass() {
        return this.klass;
    }

    @Override
    public String introduce() {
        String message = String.format("I am at %s", this.klass.getDisplayName());

        Student leader = this.klass.getLeader();
        if (leader != null && leader.equals(this)) {
            message = String.format("I am Leader of %s", this.klass.getDisplayName());
        }

        return String.format("%s I am a Student. %s.", super.introduce(), message);
    }
}
