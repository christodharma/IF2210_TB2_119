package Exception.Database;

public class NoSuchEntryException extends DatabaseException{
    public NoSuchEntryException() {
        super();
    }
    public NoSuchEntryException(String message) {
        super(message);
    }
}
