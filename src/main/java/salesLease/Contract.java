package salesLease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Contract {

    Scanner userInput = new Scanner(System.in);

    //Contract is represented as date, name, email, vehicle sold, total price, and the monthly payment
    protected String date;
    protected String customerName;
    protected String customerEmail;
    protected String vehicleSold;
    protected double totalPrice;
    protected double monthlyPayment;
    private List<Contract> allContracts = new ArrayList<>();

    public Contract(String date, String customerName, String customerEmail, String vehicleSold, double totalPrice, double monthlyPayment) {

        //Get specific private variables from the contract reading
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(String vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public List<Contract> getAllContracts() {
        return allContracts;
    }

    // Method to calculate the monthly payment
    protected double calculateMonthlyPayment(double principal, double annualInterestRate, int months) {
        // Convert annual interest rate to a monthly rate
        double monthlyInterestRate = annualInterestRate / 100 / 12;

        //calculate monthly payment
        if (monthlyInterestRate == 0) { // If no interest
            return principal / months;
        } else {
            return principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months)) /
                    (Math.pow(1 + monthlyInterestRate, months) - 1);
        }
    }
}
