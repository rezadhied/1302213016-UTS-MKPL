package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String address;
	
	private LocalDate dateJoined;
	private boolean isForeigner;
	private boolean gender; //true = Laki-laki, false = Perempuan
	
	private Salary salary;
    private FamilyMember spouse;
    private List<FamilyMember> children;

    public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, LocalDate dateJoined, boolean isForeigner, Gender gender) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.dateJoined = dateJoined;
        this.isForeigner = isForeigner;
        this.gender = gender;

        children = new LinkedList<>();
        salary = new Salary(isForeigner);
    }

    public void setMonthlySalary(int grade) {
        salary.setMonthlySalary(grade);
    }

    public void setAnnualDeductible(int deductible) {
        salary.setAnnualDeductible(deductible);
    }

    public void setAdditionalIncome(int income) {
        salary.setAdditionalIncome(income);
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        spouse = new FamilyMember(spouseName, spouseIdNumber);
    }

    public void addChild(String childName, String childIdNumber) {
        children.add(new FamilyMember(childName, childIdNumber));
    }

	public int getAnnualIncomeTax() {
        int monthWorkingInYear = LocalDate.now().getYear() == dateJoined.getYear() ? LocalDate.now().getMonthValue() - dateJoined.getMonthValue() : 12;
        return TaxFunction.calculateTax(salary.getMonthlySalary(), salary.getOtherMonthlyIncome(), monthWorkingInYear, salary.getAnnualDeductible(), salary.isSpouseEligibleForDeduction(spouse.getIdNumber()), children.size());
    }

}
