package companyManagment;

public abstract class Employee {
    private Integer id;
    private String name;
    private String surname;
    private Double salary;
    private String work;

    public Employee(String name, String surname, Double salary, String work) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.work = work;
    }

    public Employee() {
    }

    public String getDetail() {
        return surname + " " + name + ", " + salary + ", " + work;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public abstract String getEmployeeType();

    public abstract Double getOneTimeBonus();

    public abstract Double calculatePensionTax();

    public abstract Double calculateInsuranceTax();

    public Double calculateSalaryAfterAllTaxes() {
        return (salary + getOneTimeBonus()) - (calculatePensionTax() + calculateInsuranceTax());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
