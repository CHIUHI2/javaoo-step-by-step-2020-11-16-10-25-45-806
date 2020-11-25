package practice06;

public class Klass {
    private Integer number;
    private String displayName;

    public Klass(Integer number) {
        this.number = number;
        this.displayName = "Class " + number;
    }

    public Integer getNumber() { return number; }

    public String getDisplayName() { return displayName; }
}
