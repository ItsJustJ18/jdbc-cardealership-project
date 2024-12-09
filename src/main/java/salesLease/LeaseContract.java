package salesLease;

public class LeaseContract extends Contract {
    private double endingValue;
    private double leaseFee;
    private double leaseMonthlyPayment;

    public LeaseContract(String date, String customerName, String customerEmail, String vehicleSold, double totalPrice, double monthlyPayment) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);

        this.endingValue = totalPrice * .5;
        this.leaseFee = totalPrice * .07;
    }

    public double getEndingValue() {
        return endingValue;
    }

    public void setEndingValue(double endingValue) {
        this.endingValue = endingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }
    @Override
    public double getMonthlyPayment() {
        this.leaseMonthlyPayment = calculateMonthlyPayment(getTotalPrice(), 4.0, 36);
        System.out.println(" Your monthly payment is " + leaseMonthlyPayment);
        return this.leaseMonthlyPayment;
    }
    @Override
    public double getTotalPrice() {
        this.totalPrice =  endingValue + leaseFee + leaseMonthlyPayment;
        return totalPrice;
    }

}
