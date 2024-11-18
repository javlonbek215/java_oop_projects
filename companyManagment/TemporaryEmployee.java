package companyManagment;

public class TemporaryEmployee extends Employee {
    private Integer workingHours;

    public TemporaryEmployee(String name, String surname, Double salary, String work, Integer workingHours) {
        super(name, surname, salary, work);
        this.workingHours = workingHours;
    }

    public TemporaryEmployee() {}

    @Override
    public String getDetail() {
        return "Temporary Employee: " + super.getDetail() + ", " + workingHours;
    }

    @Override
    public String getEmployeeType() {
        return "Temporary Employee";
    }

    @Override
    public Double getOneTimeBonus() {
        return 0.0;
    }

    @Override
    public Double calculatePensionTax() {
        return 0.0;
    }

    @Override
    public Double calculateInsuranceTax() {
        return 0.0;
    }

    public Integer getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Integer workingHours) {
        this.workingHours = workingHours;
    }
}
