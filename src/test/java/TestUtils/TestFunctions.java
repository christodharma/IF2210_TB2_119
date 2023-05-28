package TestUtils;

import Database.Memberships.MemberDB;
import Database.Product.ProductDB;
import Exception.Database.NoSuchEntryException;
import Model.Memberships.CustomerCounter;
import Model.Memberships.Member;
import Model.Product.Price;
import Model.Product.Product;

public class TestFunctions {
    public static ProductDB templateProductDB() throws NoSuchEntryException {
        ProductDB testDB = new ProductDB();
        Product built = Product.builder(
                        "1",
                        "Indomilk",
                        5000,
                        4900,
                        "Food")
                .Quantity(0).build();
        testDB.insert(built);
        testDB.insert(built.toBuilder().ID("2").BuyPrice(new Price(4900.5)).build());
        testDB.insert(built.toBuilder().ID("3").build());
        testDB.insert(built.toBuilder().ID("4").Quantity(7357).build());
        testDB.insert(built.toBuilder().ID("5").Name("Metal Pipe").build());
        return testDB;
    }
    public static MemberDB templateMemberDB() {
        MemberDB ret = new MemberDB();
        Member m1 = new Member(CustomerCounter.setID(), "Memi", "73577357");
        Member m2 = new Member(CustomerCounter.setID(), "Momo", "735715");
        Member m = new Member(CustomerCounter.setID(), "Mime", "7357");
        ret.insert(m);
        ret.insert(m1);
        ret.insert(m2);
        return ret;
    }
}
