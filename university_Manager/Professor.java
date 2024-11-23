package university_Manager;

public class Professor extends Employee {
    private Subject subject;

    public Professor(Integer id, String name, String surname, Integer age, String birthDate, Subject subject, Double salary) {
        super(id, name, surname, age, birthDate, salary);
        this.subject = subject;
    }

    public Professor() {}

    public Subject getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "id: " + getId() + " -> " + "name: " + getName() + " -> " + "surname: " + getSurname() + " -> " + "age: " + getAge() + " -> " + "birthDate: " + getBirthDate() + " -> " + "subject: " + subject + " -> " + "salary: " + getSalary();
    }
}