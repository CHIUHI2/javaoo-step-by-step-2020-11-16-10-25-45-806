package practice10;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private Integer number;
    private String displayName;
    private Student leader;
    private List<Student> memberList;
    private Teacher teacher;

    public Klass(Integer number) {
        this.number = number;
        this.displayName = "Class " + number;
        this.memberList = new ArrayList<>();
    }

    public Integer getNumber() { return number; }

    public Student getLeader() { return leader; }

    public String getDisplayName() { return displayName; }

    public Teacher getTeacher() { return teacher; }

    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public void appendMember(Student student) {
        this.memberList.add(student);
        if(teacher != null) {
            System.out.print("I am " + teacher.getName() + ". I know " + student.getName() + " has joined " + this.displayName + ".\n");
            if(isLeader(student)) {
                System.out.print("I am " + teacher.getName() + ". I know " + student.getName() + " become Leader of " + this.displayName + ".\n");
            }
        }
    }

    public void assignLeader(Student leader) {
        if(!isIn(leader)) {
            System.out.print("It is not one of us.\n");
            return;
        }

        if(teacher != null) {
            System.out.print("I am " + teacher.getName() + ". I know " + leader.getName() + " become Leader of " + this.displayName + ".\n");
        }

        this.leader = leader;
    }

    public boolean isIn(Student student) {
        return this.memberList.stream().anyMatch(member -> member.equals(student));
    }

    public boolean isLeader(Student student) {
        if(this.leader == null) {
            return false;
        }

        return this.leader.equals(student);
    }
}
