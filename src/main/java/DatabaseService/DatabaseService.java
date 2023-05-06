package DatabaseService;

import Exception.ExtensionException;

import java.io.IOException;
public class DatabaseService {
    private final ServiceAdapter IDB;
    private final String DBPath;

    /**
     * Service for Database
     * @param idb ServiceAdapter, determines which format of data store
     * @param path Path of data store
     */

    public DatabaseService(ServiceAdapter idb, String path) {
        IDB = idb;
        DBPath = path;
    }
    public void saveData(Object data) throws IOException, ExtensionException {
        IDB.WriteDatabase(DBPath,data);
    }
    public Object loadData() throws IOException, ExtensionException {
        return IDB.ReadDatabase(DBPath);
    }
}
