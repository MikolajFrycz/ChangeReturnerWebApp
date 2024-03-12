package Frycz.Mikolaj.Cw4.prototyp.Models;

import Frycz.Mikolaj.Cw4.prototyp.Exceptions.CustomException;
import java.util.ArrayList;

import java.util.List;

/**
 * This class handles cash.
 * 
 * It is used for handling denominations, change, and solution.
 *
 */
public class Cash {
    /**
     * Entered denominations that can be used to give out change.
     */
    public List<Double> coinValues = new ArrayList<Double>();
    /**
     * Entered changed that will be given back using available denominations.
     */
    public double change = 0.0;
    /**
     * Change given in denominations.
     */
    public List<Double> solution = new ArrayList<Double>();
    
    public Cash () {
    
    }
    
    /**
     * Coin Values getter.
     * @return Coin values.
     */
    public List<Double> getCoinValues() {
        return coinValues;
    }

    /**
     * Coin Values setter.
     * @param coinValues Denominations entered by the user.
     * @throws CustomException When coinValues list is empty.
     */
    public void setCoinValues(List<Double> coinValues) throws CustomException {
        if (coinValues == null) {
            throw new CustomException("No arguments!");
        }
        else if (coinValues.isEmpty()) {
            throw new CustomException("No arguments entered!");
        }
        else
            this.coinValues = coinValues;
    }

    /**
     * Change getter.
     * @return Change.
     */
    public double getChange() {
        return change;
    }

    /**
     * Change setter.
     * @param change Change that is passed to the setter.
     */
    public void setChange(double change) {
        this.change = change;
    }

    /**
     * Solution getter.
     * @return Returns solution as a list of denominations.
     */
    public List<Double> getSolution() {
        return solution;
    }
    
    public String getSolutionAsString() {
        String tmp = "";
        for (int i = 0; i < solution.size(); i ++) {
            tmp += solution.get(i);
            tmp += ", ";
        }
        return tmp;
    }

    /**
     * Solution setter.
     * @param solution Solution passed to the setter as a list of denominations.
     */
    public void setSolution(List<Double> solution) {
        this.solution = solution;
    }
    
    public String getCoinValuesAsString() {
        String tmp = "";
        for (int i = 0; i < coinValues.size(); i ++) {
            tmp += coinValues.get(i);
            tmp += ", ";
        }
        return tmp;
    }
}
