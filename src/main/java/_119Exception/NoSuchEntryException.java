package _119Exception;

public class NoSuchEntryException extends DatabaseException{
    public NoSuchEntryException(){
        super();
    }
    public NoSuchEntryException(String message){
        super(message);
    }
    public String getMessage(){
        return super.getMessage();
    }
}
