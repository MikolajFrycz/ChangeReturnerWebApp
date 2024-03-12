package Frycz.Mikolaj.Cw4.prototyp.Controllers;

import Frycz.Mikolaj.Cw4.prototyp.Exceptions.CustomException;
import Frycz.Mikolaj.Cw4.prototyp.Models.Cash;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is used for running all the operations on cash.
 * It is most importantly used for finding the solution (Change in a most optimal way).
 * @author mikol
 */
public class CashController {

    //private CashView view;

    /**
     * Class constructor which uses CashView parameters.
     */
    public CashController() {
        
    }

    /**
     * Set the cash solution.
     * @param solution An array representing the solution.
     * @param cash The Cash object to set the solution for.
     */
    public void setCashSolution(List<Double> solution, Cash cash) {
        cash.setSolution(solution);
    }

    /**
     * Find a solution for making change using the provided Cash object.
     * @param cash The Cash object for which to find a solution.
     * @throws CustomException If there is an issue with the Cash object or change value.
     */
    public void findSolution(Cash cash) throws CustomException {

        List<Double> coinValues = cash.getCoinValues();
        double change = cash.getChange();

        if (coinValues.isEmpty()) {
            throw new CustomException("Can't find a solution if CoinValues is empty!");
        }
        if (change == 0) {
            throw new CustomException("No change entered!");
        }
        
        List<Double> sortedCoinValues = coinValues.stream()
            .sorted(Collections.reverseOrder())
            .toList();

        List<Double> tempSolution = new ArrayList<>();

        double tempChange = change;

        for (Double coinValue : sortedCoinValues) {
            while (tempChange >= coinValue) {
                tempSolution.add(coinValue);
                tempChange -= coinValue;
            }
        }

        if (tempChange == 0) {
            cash.setSolution(tempSolution);
        } else {
            cash.setSolution(Collections.singletonList(0.0));
        }
    }

    /**
     * Show the results of the Cash object's coin configuration.
     * @param cash The Cash object to display results for.
     */
    public void showResults(Cash cash) {
        //this.view.showCoins(cash);
    }

    /**
     * Create a new Cash object with the specified coin values and change amount.
     * @param coinValues A List of coin values.
     * @param change The change amount to make.
     * @return A new Cash object with the given parameters.
     */
    public Cash newCash(List<Double> coinValues, double change) {
        Cash cash = new Cash();

        try {
            cash.setCoinValues(coinValues);
        } catch (CustomException e) {
            System.out.println("Could not assign coinValues!");
        }
        cash.setChange(change);
        return cash;
    }
}
