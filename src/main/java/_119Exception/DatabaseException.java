package _119Exception;

public class DatabaseException extends _119Exception {
    public DatabaseException(){
        super();
    }
    public DatabaseException(String message){
        super(message);
    }
    public String getMessage(){
        return super.getMessage();
    }
}
