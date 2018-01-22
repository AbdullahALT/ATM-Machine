package data;

import data.Cryptography.SwapCrypto;
import data.parsers.AccountParser;
import data.parsers.LoginParser;
import data.parsers.TransferParser;
import data.sources.FileDataSource;
import model.Account;
import model.Login;
import model.Transfer;

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
                new AccountParser(),
                new SwapCrypto()
        );
    }

    public static Storage<String, List<Transfer>> getTransferStorage(String path){
        return new Storage<>(
                new FileDataSource(path),
                new TransferParser(),
                new SwapCrypto()
        );
    }

}
