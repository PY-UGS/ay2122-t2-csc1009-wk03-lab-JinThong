import java.util.Date;
import java.util.Scanner;

public class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
    }
    public  Loan(){

    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Date getLoanDate() {
        loanDate = new Date();
        return loanDate;
    }

    public double getMonthlyPayment(){
        Integer totalMonth = this.getNumberOfYears()*12;
        double monthlyInterest = (this.getAnnualInterestRate()/100)/12;
        double monthly = ((this.getLoanAmount() * monthlyInterest) / 1)/(1-(1/Math.pow((1+monthlyInterest),totalMonth)));
        return monthly;
    }
    public double getTotalPayment(){
        Double totalPayment = this.getMonthlyPayment()*(this.getNumberOfYears()*12);

        return totalPayment;
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner((System.in))) {
            System.out.print("Enter annual interest rate, for example, 8.25: ");
            double interest = input.nextFloat();
            System.out.print("Enter number of years as an integer: ");
            Integer year = input.nextInt();
            System.out.print("Enter Loan amount , for example, 120000.95: ");
            double amount = input.nextFloat();
            Loan loan = new Loan(interest,year,amount);
            System.out.println("The loan was created on"+loan.getLoanDate());
            System.out.printf("The monthly payment is %.2f\nThe total payment is %.2f",loan.getMonthlyPayment(),loan.getTotalPayment());
            }
    }
}