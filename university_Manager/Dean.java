package university_Manager;

import java.time.LocalDate;

public class Dean extends Employee{
    private String faculty;
    private LocalDate employedDate;

    public Dean(Integer id, String name, String surname, Integer age, String birthDate, String faculty, Double salary, LocalDate employedDate) {
        super(id, name, surname, age, birthDate, salary);
        this.faculty = faculty;
        this.employedDate = employedDate;
    }

    public Dean() {}


    public String getFaculty() {
        return faculty;
    }

    public LocalDate getEmployedDate() {
        return employedDate;
    }

    @Override
    public String toString() {
        return "id: " + getId() + " -> " + "name: " + getName() + " -> " + "surname: " + getSurname() + " -> " + "birthDate: " + getBirthDate() + " -> " + "faculty: " + faculty + " -> " + "salary: " + getSalary();
    }
}