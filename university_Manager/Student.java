package university_Manager;

public class Student extends Person{
    private Integer level;


    public Student(Integer id, String name, String surname, Integer age, String birthDate, Integer level) {
        super(id, name, surname, age, birthDate);
        this.level = level;
    }

    public Student() {}

    public Integer getLevel() {
        return level;
    }

    private Subject[] subjects = new Subject[10];
    private int index = 0;

    public void addSubject(Subject subject) {
        if (index == subjects.length) {
            Subject[] newArr = new Subject[subjects.length * 2];
            System.arraycopy(subjects, 0, newArr, 0, subjects.length);
            subjects = newArr;
        }
        subjects[index++] = subject;
    }

    public Subject[] getSubjectList() {
        return subjects;
    }

    @Override
    public String toString() {
        return "id: " + getId() + " -> " + "name: " + getName() + " -> " + "surname: " + getSurname() + " -> " + "age: " + getAge() + " -> " + "birthDate: " + getBirthDate() + " -> " + "level: " + level;
    }
}