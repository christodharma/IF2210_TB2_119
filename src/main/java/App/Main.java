package App;

import Customers.CustomerDB;
import Database.Member.MemberDB;
import Customers.Membership;
import Database.DatabaseService.*;
import Database.Product.ProductDB;
import GUI.MainGUI;
import _119Exception.ExtensionException;
import lombok.NonNull;

import java.io.IOException;

public class Main {
    static String DatabasePath = "src/main/resources/data/";
    static XmlService xmls = new XmlService(null);
    static ObjService objs = new ObjService(null);
    static JsonService jsons = new JsonService(null);
    static DatabaseService dbs = new DatabaseService(null, DatabasePath);
    public static ProductDB Products = new ProductDB();
    public static MemberDB Members = new MemberDB();
    public static CustomerDB Customers = new CustomerDB();
//    public static TransactionHistory Transactions = new TransactionHistory();
    public static void LoadDatabases() throws ExtensionException, IOException {
        Products = (ProductDB) setDBSXMLload(ProductDB.class,xmls,DatabasePath+"Products.xml");
        Members = (MemberDB) setDBSXMLload(MemberDB.class,xmls,DatabasePath+"Members.xml");
        Customers = (CustomerDB) setDBSXMLload(CustomerDB.class,xmls,DatabasePath+"Customers.xml");
//        Transactions = (TransactionHistory) setDBSXMLload(TransactionHistory.class,xmls,DatabasePath+"TransactionHistory.xml");
//        long temp = 0;
//        setDBSXMLload(long.class,objs,"src/main/resources/system/customerCount.obj", temp);
        objs.set_class(long.class);dbs.setIDB(objs);dbs.setDBPath("src/main/resources/system/customerCount.obj");
        long x = (long) dbs.loadData();
        dbs.reset();xmls.reset();
        Membership.setCounter(x);
    }
    public static void SaveDatabases() throws ExtensionException, IOException {
        setDBSXMLSave(ProductDB.class,xmls,DatabasePath+"Products.xml", Products);
        setDBSXMLSave(MemberDB.class,xmls,DatabasePath+"Members.xml", Members);
        setDBSXMLSave(CustomerDB.class,xmls,DatabasePath+"Customers.xml", Customers);
//        setDBSXMLSave(TransactionHistory.class,xmls,DatabasePath+"TransactionHistory.xml", Transactions);
//        long temp = 0;
//        setDBSXMLload(long.class,objs,"src/main/resources/system/customerCount.obj", temp);
        objs.set_class(long.class);dbs.setIDB(objs);dbs.setDBPath("src/main/resources/system/customerCount.obj");
        dbs.saveData(Membership.getCounter());
        dbs.reset();xmls.reset();
    }
    static Object setDBSXMLload(Class<?> setClass, @NonNull DatabaseType setDatabaseType, String setPath) throws ExtensionException, IOException {
        setDatabaseType.set_class(setClass);dbs.setIDB(xmls);dbs.setDBPath(setPath);
        Object ret = dbs.loadData();
        dbs.reset();setDatabaseType.reset();
        return ret;
    }
    static void setDBSXMLSave(Class<?> setClass, DatabaseType setDatabaseType, String setPath, Object data) throws ExtensionException, IOException {
        setDatabaseType.set_class(setClass);dbs.setIDB(xmls);dbs.setDBPath(setPath);
        dbs.saveData(data);
        dbs.reset();xmls.reset();
    }
    public static void main(String[] args) throws ExtensionException, IOException {
        LoadDatabases();
        MainGUI.main(args);
        SaveDatabases();
    }
}