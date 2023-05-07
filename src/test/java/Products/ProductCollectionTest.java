package Products;

import lombok.NonNull;

public class ProductCollectionTest {
    public static void templateProductCollection(@NonNull ProductCollection cart){
        cart.addProduct(new Product("123", "Jaket", 150000, 135000, "Clothes", 40));
        cart.addProduct(new Product("234", "Mouse", 300000, 275000, "Electronics", 40));
        cart.addProduct(new Product("345", "Celana", 150000, 135000, "Clothes", 50));
        cart.addProduct(new Product("456", "Kompor", 1000000, 999000, "Appliances", 30));
        cart.addProduct(new Product("567", "Kamera", 3000000, 2750000, "Electronics", 40));
    }
}