package Products;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.NonNull;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductDB implements Serializable {
    private static final long serialVersionUID = 11L;
    private static final String keyPrefix = "Product";
    /**
     * ProductId, Product Object
     */
    @XmlJavaTypeAdapter(ProductAdapter.class)
    public HashMap<String, Product> Products;
    public ProductDB()
    {
        this.Products = new HashMap<>();
    }
    public ProductDB(HashMap<String, Product> DB)
    {
        this.Products = DB;
    }
    public void addProduct(@NonNull Product added)
    {
        Product existingProduct = Products.get(keyPrefix + added.getID());
        if (existingProduct != null)
        {
            existingProduct.addStockQuantity(added.getStockQuantity());
        } else
        {
            Products.put(keyPrefix + added.getID(), added);
        }
    }

    /**
     * Subtracting product stockQuantity field
     * @param subtracted Non-null product in inventory
     * @param many Quantity to be subtracted
     * @return true if product is enough
     */
    public boolean subtractProduct(@NonNull Product subtracted, int many)
    {
        return (subtracted.subtractStockQuantity(many));
    }
    public void removeProduct(@NonNull Product removed)
    {
        Products.remove(removed.getID());
    }
    public void clearInventory()
    {
        Products.clear();
    }

    public Product find(String filter, String filterValue)
    {
        switch (filter){
            case "Id":
            case "id":
            case "ID":
                return Products.get(filterValue);
            case "name":
            case "NAME":
            case "Name":
                for (Product p :
                        Products.values()) {
                    if (p.getName().equals(filterValue))
                    {
                        return p;
                    }
                }
                return null;
            default:
                return null;
        }
    }
}
class ProductAdapter extends XmlAdapter<ProductMap, HashMap<String,Product>> {
    @Override
    public ProductMap marshal(HashMap<String, Product> v) throws Exception {
        ProductMap itemMap = new ProductMap();
        itemMap.items = new ArrayList<>(v.values());
        return itemMap;
    }

    @Override
    public HashMap<String, Product> unmarshal(ProductMap v) throws Exception {
        HashMap<String, Product> map = new HashMap<>();
        for (Product item : v.items) {
            map.put(item.getName(), item);
        }
        return map;
    }
}

class ProductMap {
    @JacksonXmlProperty(localName = "Product")
    List<Product> items;
}