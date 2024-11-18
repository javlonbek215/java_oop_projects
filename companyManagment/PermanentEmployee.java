package companyManagment;

public class PermanentEmployee extends Employee {
    private String room;

    public PermanentEmployee(String name, String surname, Double salary, String work, String room) {
        super(name, surname, salary, work);
        this.room = room;
    }

    public PermanentEmployee() {}

    @Override
    public String getDetail() {
        return "Permanent Employee: " + super.getDetail() + ", " + room;
    }

    @Override
    public String getEmployeeType() {
        return "Permanent Employee";
    }

    @Override
    public Double getOneTimeBonus() {
        return (getSalary() * 50) / 100;
    }

    @Override
    public Double calculatePensionTax() {
        return (getSalary() * 7.5) / 100;
    }

    @Override
    public Double calculateInsuranceTax() {
        return (getSalary() * 1) / 100;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}