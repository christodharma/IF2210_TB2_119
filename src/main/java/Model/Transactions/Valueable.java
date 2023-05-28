package Model.Transactions;

/**
 * Interface for classes that are valueable
 * Percentage > 0 is tax, < 0 is discount
 */
public interface Valueable {
    double valuate(double percentage);
}
