package Members;

import Database.DatabaseService.DatabaseService;
import Database.DatabaseService.JsonService;
import Database.DatabaseService.ObjService;
import Database.DatabaseService.XmlService;
import Database.Memberships.MemberDB;
import Exception.Database.ExtensionException;
import Model.Memberships.CustomerCounter;
import Model.Memberships.Member;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;

import static TestUtils.TestFunctions.templateMemberDB;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MemberDBTest {
    static MemberDB testDB;

    @BeforeAll
    public static void setUp(){
        testDB = templateMemberDB();
    }
    @Test
    @Order(1)
    public void MembersTest(){
        for (Member itr :
                testDB.toArrayList()) {
            assertNotEquals(CustomerCounter.count, itr.getID(), "Counter did not increment");
        }
    }

    @Test
    @Order(2)
    public void MemberDBSaveTest() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new ObjService(testDB), "src/test/resources/data/Members.obj");
        dbs.saveData(testDB);
        File file = new File("src/test/resources/data/Members.obj");
        assertTrue(file.exists());
    }

    @Test
    @Order(3)
    public void MemberDBLoadTest() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new ObjService(MemberDB.class), "src/test/resources/data/Members.obj");
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
        DatabaseService dbs = new DatabaseService(new JsonService(testDB), "src/test/resources/data/Members.json");
        dbs.saveData(testDB);
        File file = new File("src/test/resources/data/Members.json");
        assertTrue(file.exists());
    }

    @Test
    @Order(5)
    public void MemberDBLoadTestJson() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new JsonService(MemberDB.class), "src/test/resources/data/Members.json");
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
        DatabaseService dbs = new DatabaseService(new XmlService(testDB), "src/test/resources/data/Members.xml");
        dbs.saveData(testDB);
        File file = new File("src/test/resources/data/Members.xml");
        assertTrue(file.exists());
    }

    @Test
    @Order(7)
    public void MemberDBLoadTestXML() throws ExtensionException, IOException {
        DatabaseService dbs = new DatabaseService(new XmlService(MemberDB.class), "src/test/resources/data/Members.xml");
        MemberDB loaded = (MemberDB) dbs.loadData();
        assertNotNull(loaded, "Import null");
        for (Member c :
                loaded.toArrayList()) {
            assertNotEquals(String.class, c.getClass(), "Loaded DB members is wrong type");
            System.out.println(c.getID() + c.getName());
        }
    }
}