package university_Manager;

public class Person {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String birthDate;

    public Person(Integer id, String name, String surname, Integer age, String birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.birthDate = birthDate;
    }

    public Person(){}

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public String getBirthDate() {
        return birthDate;
    }
}