package Database.DatabaseService;

import Exception.Database.ExtensionException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
public class JsonService extends DatabaseType implements ServiceAdapter {

    public JsonService(Class<?> dataClass) {
        super(dataClass);
    }
    public JsonService(Object data) {
        super(data);
    }
    @Override
    public void WriteDatabase(String DestPath, Object data) throws IOException {
        try {
            File target = new File(DestPath);
            if (!DestPath.toLowerCase().endsWith(".json")){
                String fileName = target.getName();
                int index = fileName.lastIndexOf('.');
                if (index > 0) {
                    String extension = fileName.substring(index+1);
                    throw new ExtensionException("File extension is wrong! \nExpected: json\nActual: "+extension);
                }
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(target, data);
        } catch (JsonMappingException | ExtensionException exec) {
            exec.printStackTrace();
        }
    }
    @Override
    public Object ReadDatabase(String SrcPath) throws IOException, ExtensionException {
        Object data = null;
        try {
            File target = new File(SrcPath);
            if (!SrcPath.toLowerCase().endsWith(".json")){
                String fileName = target.getName();
                int index = fileName.lastIndexOf('.');
                if (index > 0) {
                    String extension = fileName.substring(index+1);
                    throw new ExtensionException("File extension is wrong! \nExpected: json\nActual: "+extension);
                }
            }
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readValue(new File(SrcPath), _class);
        } catch (JsonParseException exec) {
            exec.printStackTrace();
        }
        return data;
    }
}
