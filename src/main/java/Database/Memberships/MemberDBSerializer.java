package Database.Memberships;

import Database.DatabaseSerializer;
import Database.Product.ProductDB;

public class MemberDBSerializer extends DatabaseSerializer<ProductDB> {
    public MemberDBSerializer() {
        super("Member");
    }
}
