package MemberDB;

import Memberships.CustomerCounter;
import Memberships.Member;
import Database.DatabaseService.DatabaseService;
import Database.DatabaseService.JsonService;
import Database.DatabaseService.ObjService;
import Database.DatabaseService.XmlService;
import Database.Memberships.MemberDB;
import Exception.Database.ExtensionException;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MemberDBTest {
    static MemberDB custDB;
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
    @BeforeAll
    public static void setUp(){
        custDB = templateMemberDB();
    }
    @Test
    @Order(1)
    public void MembersTest(){
        for (Member itr :
                custDB.toArrayList()) {
            Assertions.assertNotEquals(CustomerCounter.count, itr.getID(), "Counter did not increment");
        }
    }

    @Test
    @Order(2)
    public void MemberDBSaveTest() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new ObjService(custDB), "src/test/resources/data/MembersTest.obj");
        dbs.saveData(custDB);
        File file = new File("src/test/resources/data/MembersTest.obj");
        assertTrue(file.exists());
    }

    @Test
    @Order(3)
    public void MemberDBLoadTest() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new ObjService(MemberDB.class), "src/test/resources/data/MembersTest.obj");
        MemberDB loaded = (MemberDB) dbs.loadData();
        assertNotNull(loaded, "Import null");
        for (Member c :
                loaded.toArrayList()) {
            assertNotEquals(String.class, c.getClass(), "Loaded DB members is wrong type");
//            System.out.println(c.getID());
        }
    }
    @Test
    @Order(4)
    public void MemberDBSaveTestJson() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new JsonService(custDB), "src/test/resources/data/MembersTest.json");
        dbs.saveData(custDB);
        File file = new File("src/test/resources/data/MembersTest.json");
        assertTrue(file.exists());
    }

    @Test
    @Order(5)
    public void MemberDBLoadTestJson() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new JsonService(MemberDB.class), "src/test/resources/data/MembersTest.json");
        MemberDB loaded = (MemberDB) dbs.loadData();
        assertNotNull(loaded, "Import null");
        for (Member c :
                loaded.toArrayList()) {
            assertNotEquals(String.class, c.getClass(), "Loaded DB members is wrong type");
            System.out.println(c.getID() + c.getName());
        }
    }
    @Test
    @Order(6)
    public void MemberDBSaveTestXML() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new XmlService(custDB), "src/test/resources/data/MembersTest.xml");
        dbs.saveData(custDB);
        File file = new File("src/test/resources/data/MembersTest.xml");
        assertTrue(file.exists());
    }

    @Test
    @Order(7)
    public void MemberDBLoadTestXML() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new XmlService(MemberDB.class), "src/test/resources/data/MembersTest.xml");
        MemberDB loaded = (MemberDB) dbs.loadData();
        assertNotNull(loaded, "Import null");
        for (Member c :
                loaded.toArrayList()) {
            assertNotEquals(String.class, c.getClass(), "Loaded DB members is wrong type");
            System.out.println(c.getID() + c.getName());
        }
    }
}