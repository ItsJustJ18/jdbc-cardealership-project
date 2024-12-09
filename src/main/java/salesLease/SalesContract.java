package salesLease;

public class SalesContract extends Contract {
    private double salesTax;
    private double recordingFee;
    private double processingFee;
    private boolean finance;
    private double monthlyPayment;

    public SalesContract(String date, String customerName, String customerEmail, String vehicleSold, boolean finance, double totalPrice, double monthlyPayment) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);

        this.salesTax = getTotalPrice() * .05;

        this.recordingFee = 100;

        if (getTotalPrice() <= 10000) {
            this.processingFee = 295;
        } else {
            this.processingFee = 495;
        }

        boolean customerFinance = userInput.nextLine().equalsIgnoreCase("yes");
        if (customerFinance) {
            System.out.println(" Finance has been applied. ");
        } else {
            System.out.println(" Finance option has been declined. ");
        }
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean getFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    @Override
    public double getMonthlyPayment() {

        if (getTotalPrice() >= 10000 && getFinance()) {
            this.monthlyPayment = calculateMonthlyPayment(getTotalPrice(), 4.25, 48);
            System.out.println(" For 48 months your loan is" + getMonthlyPayment());
        } else if (getTotalPrice() <= 10000 && getFinance()) {
            this.monthlyPayment = calculateMonthlyPayment(getTotalPrice(), 5.25, 24);
        }
        return this.monthlyPayment;
    }
    @Override
    public double getTotalPrice() {
        this.totalPrice =  salesTax + recordingFee + processingFee + monthlyPayment;
        return totalPrice;
    }

}



