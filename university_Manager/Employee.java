package university_Manager;

public class Employee extends Person{
    private Double salary;

    public Employee(Integer id, String name, String surname, Integer age, String birthDate, Double salary) {
        super(id, name, surname, age, birthDate);
        this.salary = salary;
    }

    public Employee(){}

    public Double getSalary() {
        return salary;
    }
}