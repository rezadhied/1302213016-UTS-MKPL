package lib;

public class TaxFunction {

	private static final double TAX_RATE = 0.05; 
    private static final int NON_TAXABLE_INCOME = 54000000; 
    private static final int SPOUSE_DEDUCTION = 4500000; 
    private static final int CHILD_DEDUCTION = 1500000;
    private static final int MAX_CHILDREN_DEDUCTION = 3 ; 
	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 */
	
	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, String spouseIdNumber, int numberOfChildren) {

        if (numberOfMonthWorking > 12) {
            System.err.println("More than 12 month working per year");
        }

        numberOfChildren = Math.min(numberOfChildren, 3);

        int grossIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
        int taxableIncome = grossIncome - deductible - calculateNonTaxableIncome(spouseIdNumber, numberOfChildren);

        taxableIncome = Math.max(taxableIncome, 0);

        return (int) Math.round(taxableIncome * TAX_RATE);
    }

    private static int calculateNonTaxableIncome(String spouseIdNumber, int numberOfChildren) {
        int nonTaxableIncome = NON_TAXABLE_INCOME;
        if (!spouseIdNumber.isEmpty()) {
            nonTaxableIncome += SPOUSE_DEDUCTION;
        }
        nonTaxableIncome += numberOfChildren * CHILD_DEDUCTION;
        return nonTaxableIncome;
    }
	
}
