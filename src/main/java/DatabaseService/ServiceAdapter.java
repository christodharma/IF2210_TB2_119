package DatabaseService;

import Exception.ExtensionException;

import java.io.IOException;
public interface ServiceAdapter{
    void WriteDatabase(String DestPath, Object data) throws IOException, ExtensionException;
    Object ReadDatabase (String SrcPath) throws IOException, ExtensionException;
/*    public Object QueryDatabase(String DestPath) throws IOException, ClassNotFoundException;
    public void UpdateDatabase();
    public void DeleteDatabase();*/
}
