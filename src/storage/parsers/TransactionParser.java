package storage.parsers;

import model.Transaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class TransactionParser implements Parser<String, List<Transaction>> {

    @Override
    public List<Transaction> parseData(String data) {
        LinkedList<Transaction> transactions = new LinkedList<>();

        try(BufferedReader reader = new BufferedReader(new StringReader(data))) {

            reader.lines().forEach(line -> {
                String[] parts = line.split(";");

                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

                try {

                    transactions.add(new Transaction(Integer.parseInt(parts[0]), parts[1], Transaction.Type.valueOf(parts[2]), Double.parseDouble(parts[3]), date.parse(parts[4])));

                } catch (ParseException e){
                    e.printStackTrace();
                }

            });

        } catch (IOException e){
            e.printStackTrace();
        }

        return transactions;
    }

    @Override
    public String unparseData(List<Transaction> transactions) {
        StringBuilder builder = new StringBuilder();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        transactions.forEach(transaction -> {
            builder.append(transaction.getUserId()).append(';');
            builder.append(transaction.getUserName()).append(';');
            builder.append(transaction.getType()).append(';');
            builder.append(transaction.getAmount()).append(';');
            builder.append(formatter.format(transaction.getDate())).append('\n');
        });

        return builder.toString();
    }
}
