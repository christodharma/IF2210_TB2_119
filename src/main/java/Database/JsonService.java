package Database;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonService<T> implements IDatabase<T>{
    private final Class<T> _class;
    public JsonService(Class<T> c){
        _class = c;
    }
    @Override
    public void WriteDatabase(String DestPath, T data) throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(DestPath), data);
        } catch (JsonMappingException exec) {
            exec.printStackTrace();
        }
    }
    @Override
    public T ReadDatabase(String SrcPath) throws IOException {
        T data = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readValue(new File(SrcPath), _class);
        } catch (JsonParseException exec) {
            exec.printStackTrace();
        }
        return data;
    }
}
