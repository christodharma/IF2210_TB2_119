package Database;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.AllArgsConstructor;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import Exception.ExtensionException;

@AllArgsConstructor
public class XmlService<T> implements IDBAdapter<T>{
    private final Class<T> _class;

    @Override
    public void WriteDatabase(String DestPath, T data) throws IOException, ExtensionException {
        try {
            File target = new File(DestPath);
            if (!DestPath.toLowerCase().endsWith(".xml")){
                String fileName = target.getName();
                int index = fileName.lastIndexOf('.');
                if (index > 0) {
                    String extension = fileName.substring(index+1);
                    throw new ExtensionException("File extension is wrong! \nExpected: xml\nActual: "+extension);
                }
            }
            StringWriter stringWriter = new StringWriter();
            XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(stringWriter);
            writer.writeStartDocument("UTF-8", "1.0");
            XmlMapper mapper = new XmlMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(DestPath), data);
        } catch (JsonMappingException | XMLStreamException exec) {
            exec.printStackTrace();
        }
    }

    @Override
    public T ReadDatabase(String SrcPath) throws IOException, ExtensionException {
        T data = null;
        try {
            File target = new File(SrcPath);
            if (!SrcPath.toLowerCase().endsWith(".xml")){
                String fileName = target.getName();
                int index = fileName.lastIndexOf('.');
                if (index > 0) {
                    String extension = fileName.substring(index+1);
                    throw new ExtensionException("File extension is wrong! \nExpected: xml\nActual: "+extension);
                }
            }
            XmlMapper mapper = new XmlMapper();
            data = mapper.readValue(target, _class);
        } catch (JsonParseException exec) {
            exec.printStackTrace();
        }
        return data;
    }
}
