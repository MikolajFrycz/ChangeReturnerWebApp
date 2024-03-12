package Frycz.Mikolaj.Cw4.prototyp.Views;

import Frycz.Mikolaj.Cw4.prototyp.Models.Cash;
import java.io.PrintWriter;

/**
 * Class used for cash interface and display.
 * 
 * Used for printing information on screen.
 * @author mikol
 */
public class CashView {
    
    /**
     * Method used for displaying available denominations, change, and solution on screen.
     * @param cash Cash parameter which holds all the cash-related values.
     */
    public void showCoins(Cash cash){
    
        System.out.println("Avialiable nominals:");
        for (Double coinValue : cash.getCoinValues()) {
            System.out.print(coinValue + " ");
        }
        System.out.println();
        
        System.out.println("Change: ");
        System.out.print(cash.getChange());
        System.out.println();
        
        System.out.println("Solution:");
        for (Double solutionValue : cash.getSolution()) {
            System.out.print(solutionValue + " ");
        }
    }
    
    public void PrintStringResult(PrintWriter out, String result) {
        out.println("Change in cash: " + result +"\n");
    }
}
