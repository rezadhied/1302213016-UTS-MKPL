package lib;

public class Salary {
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;
    private boolean isForeigner;

    public Salary(boolean isForeigner) {
        this.isForeigner = isForeigner;
    }

    public void setMonthlySalary(int grade) {
        this.monthlySalary = calculateBaseSalary(grade);
        if (isForeigner) {
            this.monthlySalary *= 1.5;
        }
    }

    private int calculateBaseSalary(int grade) {
        switch (grade) {
            case 1:
                return 3000000;
            case 2:
                return 5000000;
            case 3:
                return 7000000;
            default:
                throw new IllegalArgumentException("Invalid grade");
        }
    }

    public int getMonthlySalary(){
        return monthlySalary;
    }

    public int getOtherMonthlyIncome(){
        return otherMonthlyIncome;
    }

    public int getAnnualDeductible(){
        return annualDeductible;
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public boolean isSpouseEligibleForDeduction(String spouseIdNumber) {
        return spouseIdNumber.equals("");
    }
}
