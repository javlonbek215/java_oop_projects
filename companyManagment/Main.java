package companyManagment;

public class Main {
    public static void main(String[] args) {

        CompanyManagement companyManager = new CompanyManagement();

        companyManager.addPermanentEmployee("Ali", "Aliyev", 1000d, "Aparatchi", "1a");
        companyManager.addPermanentEmployee("Vali", "Valiyev", 700d, "Choychi", "1d");

        companyManager.addSeasonalEmployee("Axmad", "Axmadov", 400d, "Olma terish", "Autumn");
        companyManager.addSeasonalEmployee("Toshmad", "Toshmatov", 500d, "Qorovul", "Autumn");

        companyManager.addTemporaryEmployee("Eshmad", "Eshmatov", 100d, "Work1", 5);

        companyManager.addPartnerEmployee("Vohid", "Sohibov", 200d, "Yordamchi", "Chang - Chung");
        companyManager.addPartnerEmployee("Zohid", "Ortiqov", 300d, "Katta yordamchi", "Chang - Chung");

        companyManager.addEarEmployee("Quloq", "Quloqov", 50d, "Terpillalik");

         companyManager.printAllEmployeeDetail();

         companyManager.printAllEmployeeType();

        companyManager.showAllEmployeeBonus();

        companyManager.showAllPensionTax();

        companyManager.showAllInsuranceTax();

        companyManager.showAllSalaryAfterAllTaxes();

    }
}