package Database;

import java.io.*;

import Exception.ExtensionException;
public class ObjService<T> implements IDBAdapter<T> {
    @Override
    public void WriteDatabase(String DestPath, T data) throws IOException, ExtensionException {
        File target = new File(DestPath);
        if (!DestPath.toLowerCase().endsWith(".obj")){
            String fileName = target.getName();
            int index = fileName.lastIndexOf('.');
            if (index > 0) {
                String extension = fileName.substring(index+1);
                throw new ExtensionException("File extension is wrong! \nExpected: obj\nActual: "+extension);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(DestPath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(data);
        objectOutputStream.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T ReadDatabase(String SrcPath) throws IOException, ExtensionException{
        Object readObs = null;
        try {
            File target = new File(SrcPath);
            if (!SrcPath.toLowerCase().endsWith(".obj")){
                String fileName = target.getName();
                int index = fileName.lastIndexOf('.');
                if (index > 0) {
                    String extension = fileName.substring(index+1);
                    throw new ExtensionException("File extension is wrong! \nExpected: obj\nActual: "+extension);
                }
            }
            FileInputStream fileInputStream = new FileInputStream(SrcPath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            readObs = objectInputStream.readObject();
            objectInputStream.close();
        } catch (ClassNotFoundException exec) {
            exec.printStackTrace();
        }
        return (T) readObs;
    }
    /*
//        /**
//         * TODO: Query should implement Reflect API Executable
//         * @param DestPath Path of db file
//         * @return Elements of read db file
//         * @throws IOException File is not found or invalid path
//         * @throws ClassNotFoundException Class not found exception

    @Override
    @SuppressWarnings("unchecked")
    public Object QueryDatabase(String DestPath) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(DestPath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        T readObs = (T) objectInputStream.readObject();
        objectInputStream.close();
        return null;
    }

    @Override
    public void UpdateDatabase() {

    }

    @Override
    public void DeleteDatabase() {

    }
    */
}
