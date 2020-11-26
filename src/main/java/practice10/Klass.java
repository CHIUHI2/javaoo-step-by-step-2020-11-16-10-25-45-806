package practice10;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Klass extends Observable {
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
        if(!this.memberList.contains(student)) {
            this.memberList.add(student);
        }

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

    @Override
    public synchronized void addObserver(Observer observer) {
        if(observer == null) {
            return;
        }

        this.teacherList.add((Teacher) observer);
    }

    public void inform(String actionType, Student student) {
        teacherList.stream().forEach(teacher -> teacher.notifyForAction(this, student, actionType));
    }
}
