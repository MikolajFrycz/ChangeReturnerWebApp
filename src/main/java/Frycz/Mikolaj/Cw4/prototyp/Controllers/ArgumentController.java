package Frycz.Mikolaj.Cw4.prototyp.Controllers;

import Frycz.Mikolaj.Cw4.prototyp.Exceptions.CustomException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * The ArgumentController class is responsible for handling GUI-input arguments
 * and performing various checks on them.
 * @param <T> This class is generic and different types can be used to initiate its objects.
 */
public class ArgumentController<T> {

    private List<T> denominationsArgs;
    private T changeArg;

    /**
     * Get the denominations arguments.
     *
     * @return A List of denomination arguments.
     */
    public List<T> getDenominationsArgs() {
        return denominationsArgs;
    }
    
    /**
     * Get the change argument.
     *
     * @return Change argument.
     */
    public T getChangeArg() {
        return changeArg;
    }

    /**
     * Constructor for the ArgumentController class.
     *
     * @param denominationsArgs A List of denominations arguments.
     * @param changeArg Change argument.
     */
    public ArgumentController(List<T> denominationsArgs, T changeArg) {
        this.denominationsArgs = denominationsArgs;
        this.changeArg = changeArg;
    }

    /**
     * Set the arguments.
     *
     * @param denominationsArgs A List of denominations arguments.
     * @param changeArg Change argument.
     */
    public void setArguments(List<T> denominationsArgs, T changeArg) {
        this.denominationsArgs = denominationsArgs;
        this.changeArg = changeArg;
    }

    /**
     * Check if  is a valid double value.
     *
     * @return The last argument as a double if it is valid.
     * @throws CustomException if the last argument is not a valid double.
     */
    public double checkChange() throws CustomException {

        Pattern pattern = Pattern.compile("[-+]?\\d*\\.?\\d+([eE][-+]?\\d+)?");

        double doubleChange = 0;

        if (!pattern.matcher((CharSequence) this.getChangeArg()).matches()) {
            
            throw new CustomException("Wrong arguments");
        } else {
            doubleChange = Double.parseDouble(this.getChangeArg().toString());
        }

        return doubleChange;
    }

    /**
     * Check if all arguments except the last one are valid double values.
     *
     * @return A List of valid double values.
     * @throws CustomException if any of the arguments are not valid doubles.
     */
    public List<Double> checkCoins() throws CustomException {

        Pattern pattern = Pattern.compile("[-+]?\\d*\\.?\\d+([eE][-+]?\\d+)?");

        List<Double> doubleCoins = new ArrayList<>();

        for (int i = 0; i < this.getDenominationsArgs().size() ; i++) {
            if (!pattern.matcher((CharSequence) this.getDenominationsArgs().get(i)).matches()) {
                throw new CustomException("Wrong arguments");
            } else {
                doubleCoins.add(Double.valueOf((String) this.getDenominationsArgs().get(i)));
            }
        }
        


        return doubleCoins;
    }

}
