import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        final double AVGSPYRET = 0.085;
        //get inputs
        Scanner scaner = new Scanner(System.in);
        System.out.print("Enter Vehichle Price in USD: ");
        float vehPrice = scaner.nextFloat();
        System.out.print("Enter Offered Interest Rate: ");
        double IntRate = scaner.nextDouble()/100;
        System.out.print("Enter Anticipated Downpayment(%): ");
        double downPayment = scaner.nextDouble()/100;
        System.out.print("Enter Anticipated Loan Term(years): ");
        int loanTerm = scaner.nextInt();

        //calculations
        double realAPY = (AVGSPYRET - IntRate);
        double availableFunds = vehPrice*(1-downPayment);
        double finalAPY = availableFunds*Math.pow((1+realAPY), loanTerm) - availableFunds;
        System.out.println("Based On Historical Average Market Performance you will earn $" + String.format("%,.2f", finalAPY) +" If You Finance Your Vehicle Instead Of Buying It Cash");


    }
}
