package companyManagment;

public class SeasonalEmployees extends Employee {
    private String season;

    public SeasonalEmployees(String name, String surname, Double salary, String work, String season) {
        super(name, surname, salary, work);
        this.season = season;
    }

    public SeasonalEmployees() {}

    @Override
    public String getDetail() {
        return "Seasonal Employees: " + super.getDetail() + ", " + season;
    }

    @Override
    public String getEmployeeType() {
        return "Seasonal Employees";
    }

    @Override
    public Double getOneTimeBonus() {
        return (getSalary() * 20) / 100;
    }

    @Override
    public Double calculateInsuranceTax() {
        return (getSalary() * 0.5) / 100;
    }

    @Override
    public Double calculatePensionTax() {
        return (getSalary() * 5.5) / 100;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
