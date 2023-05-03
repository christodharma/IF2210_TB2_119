package Database;

import java.io.*;

public class ObjService<T> implements IDatabase<T> {
    @Override
    public void WriteDatabase(String DestPath, T data) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(DestPath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(data);
        objectOutputStream.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public T ReadDatabase(String SrcPath) throws IOException {
        Object readObs = null;
        try {
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
