package companyManagment;

public class CompanyManagement {
    //Employee
    Employee[] employees = new Employee[10];
    private int employeeIndex = 0;


    public PermanentEmployee addPermanentEmployee(String name, String surname, Double salary, String work, String room) {
        PermanentEmployee permanentEmployee = new PermanentEmployee(name, surname, salary, work, room);

        if (employeeIndex == employees.length) {
            Employee[] newArr = new Employee[employees.length * 2];
            for (int i = 0; i < employees.length; i++) {
                employees[i] = newArr[i];
            }
            employees = newArr;
        }
        employees[employeeIndex++] = permanentEmployee;
        return permanentEmployee;
    }

    public SeasonalEmployees addSeasonalEmployee(String name, String surname, Double salary, String work, String season) {
        SeasonalEmployees seasonalEmployees1 = new SeasonalEmployees(name, surname, salary, work, season);

        if (employeeIndex == employees.length) {
            Employee[] newArr = new Employee[employees.length * 2];
            for (int i = 0; i < employees.length; i++) {
                employees[i] = newArr[i];
            }
            employees = newArr;
        }
        employees[employeeIndex++] = seasonalEmployees1;
        return seasonalEmployees1;
    }

    public TemporaryEmployee addTemporaryEmployee(String name, String surname, Double salary, String work, Integer workingHours) {
        TemporaryEmployee temporaryEmployee = new TemporaryEmployee(name, surname, salary, work, workingHours);

        if (employeeIndex == employees.length) {
            Employee[] newArr = new Employee[employees.length * 2];
            for (int i = 0; i < employees.length; i++) {
                employees[i] = newArr[i];
            }
            employees = newArr;
        }
        employees[employeeIndex++] = temporaryEmployee;

        return temporaryEmployee;
    }

    public PartnerEmployee addPartnerEmployee(String name, String surname, Double salary, String work, String companyName) {
        PartnerEmployee partnerEmployee = new PartnerEmployee(name, surname, salary, work, companyName);

        if (employeeIndex == employees.length) {
            Employee[] newArr = new Employee[employees.length * 2];
            for (int i = 0; i < employees.length; i++) {
                employees[i] = newArr[i];
            }
            employees = newArr;
        }
        employees[employeeIndex++] = partnerEmployee;

        return partnerEmployee;
    }

    public EarEmployee addEarEmployee(String name, String surname, Double salary, String work) {
        EarEmployee earEmployee = new EarEmployee(name, surname, salary, work);

        if (employeeIndex == employees.length) {
            Employee[] newArr = new Employee[employees.length * 2];
            for (int i = 0; i < employees.length; i++) {
                employees[i] = newArr[i];
            }
            employees = newArr;
        }
        employees[employeeIndex++] = earEmployee;

        return earEmployee;
    }

    public void printAllEmployeeDetail() {
        for (Employee permanentEmployee : employees) {
            if (permanentEmployee != null) {
                System.out.println(permanentEmployee.getDetail());
            }
        }
    }

    public void printAllEmployeeType() {
        for (Employee permanentEmployee : employees) {
            if (permanentEmployee != null) {
                System.out.println(permanentEmployee.getSurname() + " " + permanentEmployee.getName() + " " + permanentEmployee.getEmployeeType());
            }
        }
    }

    public void showAllEmployeeBonus() {
        for (Employee permanentEmployee : employees) {
            if (permanentEmployee != null) {
                System.out.println(permanentEmployee.getSurname() + " " + permanentEmployee.getName() + " " + permanentEmployee.getOneTimeBonus());
            }
        }
    }

    public void showAllPensionTax() {
        for (Employee permanentEmployee : employees) {
            if (permanentEmployee != null) {
                System.out.println(permanentEmployee.getSurname() + " " + permanentEmployee.getName() + " " + permanentEmployee.calculatePensionTax());
            }
        }
    }

    public void showAllInsuranceTax() {
        for (Employee permanentEmployee : employees) {
            if (permanentEmployee != null) {
                System.out.println(permanentEmployee.getSurname() + " " + permanentEmployee.getName() + " " + permanentEmployee.calculateInsuranceTax());
            }
        }
    }

    public void showAllSalaryAfterAllTaxes() {
        for (Employee permanentEmployee : employees) {
            if (permanentEmployee != null) {
                System.out.println(permanentEmployee.getSurname() + " " + permanentEmployee.getName() + " " + permanentEmployee.calculateSalaryAfterAllTaxes());
            }
        }
    }
}