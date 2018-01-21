package data.parsers;

import model.Account;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

public class AccountParser implements Parser<String, List<Account>>{

    @Override
    public List<Account> parseData(String data) {

        LinkedList<Account> accounts = new LinkedList<>();

        BufferedReader reader = new BufferedReader(new StringReader(data));

        reader.lines().forEach(line ->{

            String[] parts = line.split(";");

            accounts.add(new Account(parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]), parts[5]));

        });

        return accounts;
    }

    @Override
    public String unparseData(List<Account> accounts) {

        StringBuilder builder = new StringBuilder();

        accounts.forEach( account -> {
            builder.append(account.getUserId()).append(';');
            builder.append(account.getAccountId()).append(';');
            builder.append(account.getName()).append(';');
            builder.append(account.getType()).append(';');
            builder.append(account.getBalance()).append(';');
            builder.append(account.getStatus()).append('\n');
        });

        return builder.toString();
    }


}
