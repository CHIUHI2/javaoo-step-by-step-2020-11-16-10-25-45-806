package practice10;

import java.util.ArrayList;
import java.util.List;

public class Klass extends KlassObservable {
    private final Integer number;
    private final String displayName;
    private Student leader;
    private List<Student> memberList;

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

        this.setChanged();
        this.setEvent(KlassObservableEvent.APPEND_MEMBER);
        this.notifyObservers(student);
    }

    public void assignLeader(Student student) {
        if(!isIn(student)) {
            System.out.print("It is not one of us.\n");
            return;
        }

        this.leader = student;

        this.setChanged();
        this.setEvent(KlassObservableEvent.ASSIGN_LEADER);
        this.notifyObservers(student);
    }

    public boolean isIn(Student student) {
        return this.memberList.stream().anyMatch(member -> member.equals(student));
    }
}
