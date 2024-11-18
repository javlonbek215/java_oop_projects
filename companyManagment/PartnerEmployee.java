package companyManagment;

public class PartnerEmployee extends Employee {
    private String companyName;

    public PartnerEmployee() {

    }

    @Override
    public String getEmployeeType() {
        return "Partner Employee";
    }

    public PartnerEmployee(String name, String surname, Double salary, String work, String companyName) {
        super(name, surname, salary, work);
        this.companyName = companyName;
    }

    @Override
    public Double getOneTimeBonus() {
        return (getSalary() * 75) / 100;
    }

    @Override
    public Double calculatePensionTax() {
        return (getSalary() * 5) / 100;
    }

    @Override
    public Double calculateInsuranceTax() {
        return 0.0;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
