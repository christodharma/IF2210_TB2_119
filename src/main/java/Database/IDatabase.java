package Database;

import java.io.IOException;

public interface IDatabase<T> {
    void WriteDatabase(String DestPath, T data) throws IOException;
    T ReadDatabase (String SrcPath) throws IOException;
/*    public Object QueryDatabase(String DestPath) throws IOException, ClassNotFoundException;
    public void UpdateDatabase();
    public void DeleteDatabase();*/
}
