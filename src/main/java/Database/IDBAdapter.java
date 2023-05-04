package Database;

import java.io.IOException;
import Exception.ExtensionException;
public interface IDBAdapter<T> {
    void WriteDatabase(String DestPath, T data) throws IOException, ExtensionException;
    T ReadDatabase (String SrcPath) throws IOException, ExtensionException;
/*    public Object QueryDatabase(String DestPath) throws IOException, ClassNotFoundException;
    public void UpdateDatabase();
    public void DeleteDatabase();*/
}
