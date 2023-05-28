package Database;

import Exception.Database.NoSuchEntryException;

public interface DatabaseOperations<T>{
    void insert(T element) throws NoSuchEntryException;

    T select(Object keyword) throws NoSuchEntryException;

    void update(Object keyword) throws NoSuchEntryException;

    T delete(Object keyword) throws NoSuchEntryException;
}
