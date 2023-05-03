package Database;

import java.io.IOException;

public class Database<T> {
    private final IDBAdapter<T> IDB;
    private final String DBPath;

    public Database(IDBAdapter<T> idb, String path) {
        IDB = idb;
        DBPath = path;
    }
    public void saveData(T data) throws IOException {
        IDB.WriteDatabase(DBPath,data);
    }
    public T loadData() throws IOException, ClassNotFoundException {
        return IDB.ReadDatabase(DBPath);
    }
}
