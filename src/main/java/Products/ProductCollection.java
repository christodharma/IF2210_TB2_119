package Products;

import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
@NoArgsConstructor
public class ProductCollection {
    protected ArrayList<Product> contents = new ArrayList<>();
    public void addProduct(@NonNull Product added)
    {
        for (Product itr :
                contents) {
            if (itr.equals(added)) {
                itr.addQuantity(added.getQuantity());
                return;
            }
        }
        contents.add(added);
    }
    public boolean subtractProduct(@NonNull Product subtracted, int many)
    {
        return (findProduct("ID", subtracted.getID()).subtractQuantity(many));
    }
    public void removeProduct(Product removed)
    {
        contents.remove(findProduct("ID", removed.getID()));
    }
    public void clearContents()
    {
        contents.clear();
    }
    public Product findProduct(String filter, String filterValue)
    {
        switch (filter){
            case "Id":
            case "id":
            case "ID":
                for (Product itr :
                        contents) {
                    if (itr.getID() == filterValue) {
                        return itr;
                    }
                }
            case "name":
            case "NAME":
            case "Name":
                for (Product itr :
                        contents) {
                    if (itr.getName() == filterValue) {
                        return itr;
                    }
                }
            default:
                return null;
        }
    }
    public ArrayList<Product> getProducts(){
        return contents;
    }
}
