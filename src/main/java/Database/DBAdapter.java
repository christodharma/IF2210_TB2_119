package Database;

import java.io.IOException;

public class DBAdapter<T> {
    private final IDatabase<T> IDB;
    private final String DBPath;

    public DBAdapter(IDatabase<T> idb, String path) {
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
