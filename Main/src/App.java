import java.time.Year;
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
        System.out.print("Enter Anticipated Downpayment(USD amount): ");
        double downPayment = scaner.nextDouble()/vehPrice;
        System.out.print("Enter Anticipated Loan Term(years): ");
        int loanTerm = scaner.nextInt();

        //calculations
        //double realAPY = (AVGSPYRET - IntRate);
        double principal = vehPrice*(1-downPayment);
        double monthlyPayment = (principal*(1+IntRate))/loanTerm/12;
        double monthIR = AVGSPYRET/12;
        //double tp = principal;
        double profit = 0;
        for(int i=0; i<loanTerm*12;i++){
            principal  = principal - monthlyPayment;
            double earned = principal*monthIR;
            profit = profit + earned;
            principal = principal + earned;
        }
        profit = profit - principal*IntRate;


        if(profit >=0){
            System.out.println("Based On Historical Average Market Performance you will earn $" + String.format("%,.2f", profit) +" If You Finance Your Vehicle Instead Of Buying It In Cash. If This Amount Is Significant To You - Make Yhe Downpayment And Invest The Rest Of The Money In Index Fund Such As $SPY, $VOO, $SPYG, $VTI (Not A Financial Advice).");
        }
        else{
            System.out.println("Your Interest Rate Is Higher Than Historical Average Market Return So You Will loose $" + String.format("%,.2f", profit*(-1)) + " In Interest Payments If You Decide To Finance Your Vehicle. In This Situation Its Better To Buy It in Cash If You Can.");
        }
        


    }
}
