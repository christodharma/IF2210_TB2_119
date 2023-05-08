package Products;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashMap;

@NoArgsConstructor
@JsonRootName("ProductDB")
public class ProductDB extends ProductCollection implements Serializable {
    private static final long serialVersionUID = 11L;
}