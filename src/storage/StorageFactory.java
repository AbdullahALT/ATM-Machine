package storage;

import model.Account;
import model.Login;
import model.Transaction;
import storage.Cryptography.SwapCrypto;
import storage.parsers.AccountParser;
import storage.parsers.LoginParser;
import storage.parsers.TransactionParser;
import storage.sources.FileDataSource;

import java.util.List;

public class StorageFactory {

    public static Storage<String, List<Login>> getLoginStorage(String path){
        return new Storage<>(
                new FileDataSource(path),
                new LoginParser(),
                new SwapCrypto()
        );
    }

    public static Storage<String, List<Account>> getAccountStorage(String path){
        return new Storage<>(
                new FileDataSource(path),
                new AccountParser()
        );
    }

    public static Storage<String, List<Transaction>> getTransactionStorage(String path){
        return new Storage<>(
                new FileDataSource(path),
                new TransactionParser()
        );
    }

}
