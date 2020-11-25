package practice10;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private Integer number;
    private String displayName;
    private Student leader;
    private List<Student> memberList;
    private ArrayList<Teacher> teacherList = new ArrayList<>();

    public Klass(Integer number) {
        this.number = number;
        this.displayName = "Class " + number;
        this.memberList = new ArrayList<>();
    }

    public Integer getNumber() { return number; }

    public Student getLeader() { return leader; }

    public String getDisplayName() { return displayName; }

    public void appendMember(Student student) {
        this.memberList.add(student);
        this.inform("appendMember", student);
    }

    public void assignLeader(Student leader) {
        if(!isIn(leader)) {
            System.out.print("It is not one of us.\n");
            return;
        }

        this.leader = leader;
        this.inform("assignLeader", leader);
    }

    public boolean isIn(Student student) {
        return this.memberList.stream().anyMatch(member -> member.equals(student));
    }

    public void register(Teacher teacher) {
        this.teacherList.add(teacher);
    }

    public void inform(String actionType, Student student) {
        teacherList.stream().forEach(teacher -> teacher.notify(actionType, student, this));
    }
}
