package Database;

import java.io.IOException;
import Exception.ExtensionException;
public class Database<T> {
    private final IDBAdapter<T> IDB;
    private final String DBPath;

    public Database(IDBAdapter<T> idb, String path) {
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
