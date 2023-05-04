package Database;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import Exception.ExtensionException;

public class DatabaseFormatChange<T> {
    private DatabaseService<T> sourceDatabaseService;
    private DatabaseService<T> destDatabaseService;
    private static ArrayList<String> ValidFormats = new ArrayList<>(Arrays.asList("xml", "json", "obj"));
    private static ArrayList<String> PassedFormats;
    public DatabaseFormatChange(String FromFormat, String ToFormat, T data, String path)
            throws ExtensionException, ClassNotFoundException, NoSuchMethodException {
        PassedFormats = new ArrayList<>(Arrays.asList(FromFormat.toLowerCase(), ToFormat.toLowerCase()));
        if (!ValidFormats.containsAll(PassedFormats)){
            throw new ExtensionException("Format is not valid\nFormats Valid: "+ ValidFormats +"\nActual: "+PassedFormats);
        }
        FromFormat = Capitalize(FromFormat);
        ToFormat = Capitalize(ToFormat);
        sourceDatabaseService = new DatabaseService<T>(
                new ObjService<>(),
                path);
    }
    public String Capitalize(String what)
    {
        return what.substring(0,1).toUpperCase()+what.substring(1);
    }
    public Object getService(String what) throws ClassNotFoundException, NoSuchMethodException {
        Class<? extends Object> whatServiceClass = Class.forName(what+"Service");
        Constructor<? extends Object> whatCtor = whatServiceClass.getConstructor(String.class);
        return whatCtor.newInstance(Class<T>);
    }
}
