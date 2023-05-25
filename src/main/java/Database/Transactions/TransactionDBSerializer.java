package Database.Transactions;

import Database.DatabaseSerializer;

public class TransactionDBSerializer extends DatabaseSerializer<TransactionDB> {
    public TransactionDBSerializer() {
        super("Transaction");
    }
}
