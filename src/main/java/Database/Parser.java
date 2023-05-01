package Database;

import java.io.*;

public class Parser<T> {
    public String format = "OBJ";
    public void WriteDatabase(String filepath, T data) throws IOException {
        switch (format){
            case "OBJ":
                FileOutputStream fileOutputStream = new FileOutputStream(filepath);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(data);
                objectOutputStream.close();
                break;
            case "XML":
            case "JSON":
                break;
        }
    }
    public T ReadDatabase(String filepath) throws IOException, ClassNotFoundException {
        switch (format){
            case "OBJ":
                FileInputStream fileInputStream = new FileInputStream(filepath);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                T readObjs = (T) objectInputStream.readObject();
                objectInputStream.close();
                return readObjs;
            case "XML":
            case "JSON":
                break;
        }
        return null;
    }
    public void ChangeFormat(String into){
        if (into.equals("XML")||into.equals("OBJ")||into.equals("JSON")){
            format = into;
        }
    }
}
