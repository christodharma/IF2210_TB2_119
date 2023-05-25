package Database.DatabaseService;

import _119Exception.ExtensionException;
import lombok.Setter;

import java.io.IOException;
@Setter
public class DatabaseService {
    private ServiceAdapter IDB;
    private String DBPath;

    /**
     * Service for Database
     * @param idb ServiceAdapter, determines which format of data store
     * @param path Path of data store
     */
    public DatabaseService(ServiceAdapter idb, String path) {
        IDB = idb;
        DBPath = path;
    }
    //TODO: review adapter design pattern
    public void saveData(Object data) throws IOException, ExtensionException {
        IDB.WriteDatabase(DBPath,data);
    }
    public Object loadData() throws IOException, ExtensionException {
        return IDB.ReadDatabase(DBPath);
    }
    public void reset(){
        IDB=null;
        DBPath=null;
    }
}
