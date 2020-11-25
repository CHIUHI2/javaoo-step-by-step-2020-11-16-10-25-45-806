package practice07;

public class Klass {
    private Integer number;
    private String displayName;
    private Student leader;

    public Klass(Integer number) {
        this.number = number;
        this.displayName = "Class " + number;
    }

    public Integer getNumber() { return number; }

    public Student getLeader() { return leader; }

    public String getDisplayName() { return displayName; }

    public void assignLeader(Student leader) { this.leader = leader; }
}
