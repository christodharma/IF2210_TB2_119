package Database;

import java.util.ArrayList;
import java.util.Arrays;

public class DatabaseFormatChange<T> {
    private DatabaseService<T> sourceDatabaseService;
    private DatabaseService<T> destDatabaseService;
    private static ArrayList<String> ValidFormats = new ArrayList<>(Arrays.asList("xml", "json", "obj"));
    public DatabaseFormatChange(String FromFormat, String ToFormat, T data){
        if (ValidFormats.containsAll(Arrays.asList(FromFormat, ToFormat))){

        }
    }
}
