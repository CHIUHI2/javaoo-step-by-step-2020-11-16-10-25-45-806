package practice09;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private Integer number;
    private String displayName;
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

    public void appendMember(Student student) { this.memberList.add(student); }

    public void assignLeader(Student leader) {
        if(!this.memberList.contains(leader)) {
            System.out.print("It is not one of us.\n");
            return;
        }

        this.leader = leader;
    }
}
