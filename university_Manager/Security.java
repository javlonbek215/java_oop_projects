package university_Manager;

public class Security extends Employee{
    private String militaryRank;

    public Security(Integer id, String name, String surname, Integer age, String birthDate, Double salary, String militaryRank) {
        super(id, name, surname, age, birthDate, salary);
        this.militaryRank = militaryRank;
    }

    public Security() {}

    public String getMilitaryRank() {
        return militaryRank;
    }

    @Override
    public String toString() {
        return "id: " + getId() + " -> " + "name: " + getName() + " -> " + "surname: " + getSurname() + " -> " + "birthDate: " + getBirthDate() + " -> " + "salary: " + getSalary() + " -> " + "militaryRank: " + militaryRank;
    }
}