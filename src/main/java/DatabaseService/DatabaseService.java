package DatabaseService;

import java.io.IOException;
import Exception.ExtensionException;
public class DatabaseService {
    private final ServiceAdapter IDB;
    private final String DBPath;

    /**
     * Service for Database
     * @param idb ServiceAdapter,
     * @param path
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
