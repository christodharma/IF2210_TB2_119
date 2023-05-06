package Database;

public class DatabaseType<T>{
    protected final Class<T> _class;
    public DatabaseType(Class<T> dataClass) {
        _class = dataClass;
    }
    @SuppressWarnings("unchecked")
    public DatabaseType (T data) {
        _class = (Class<T>) data.getClass();
    }
}
