package Database;

import java.io.IOException;
import Exception.ExtensionException;
public class DatabaseService<T> {
    private final IDBAdapter<T> IDB;
    private final String DBPath;

    public DatabaseService(IDBAdapter<T> idb, String path) {
        IDB = idb;
        DBPath = path;
    }
    public void saveData(T data) throws IOException, ExtensionException {
        IDB.WriteDatabase(DBPath,data);
    }
    public T loadData() throws IOException, ClassNotFoundException, ExtensionException {
        return IDB.ReadDatabase(DBPath);
    }
}
