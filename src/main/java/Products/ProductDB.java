package Products;

import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
public class ProductDB extends ProductCollection implements Serializable {
    private static final long serialVersionUID = 11L;
}