package Database;

import java.io.IOException;

public interface IDBAdapter<T> {
    void WriteDatabase(String DestPath, T data) throws IOException;
    T ReadDatabase (String SrcPath) throws IOException, ClassNotFoundException;
/*    public Object QueryDatabase(String DestPath) throws IOException, ClassNotFoundException;
    public void UpdateDatabase();
    public void DeleteDatabase();*/
}
