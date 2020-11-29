package practice10;

public class Person {
    private Integer id;
    private String name;
    private int age;

    public Person(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String introduce() {
        return String.format("My name is %s. I am %d years old.", this.name, this.age);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person)) {
            return false;
        }

        Person person = (Person) o;

        return person.getId().equals(this.id);
    }
}
