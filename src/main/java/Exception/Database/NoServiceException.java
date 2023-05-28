package Exception.Database;

public class NoServiceException extends DatabaseException{
    public NoServiceException(){
        super();
    }
    public NoServiceException(String message){
        super(message);
    }
}
