/**
 * Created by alexey on 08.03.16.
 */

/**
 * Interface for functions that are able to be calculated as x = f(y).
 */
public interface BackwardCalculable {

    /**
     * Returns array of possible arguments that satisfy condition f(arg) = y.
     * Array is sorted by ascendancy.
     *
     * @param y Value of function.
     * @return Array of possible arguments.
     */
    double[] doBackwardCalculation(final double y);
}
