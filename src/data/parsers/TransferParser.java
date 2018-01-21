package data.parsers;

import model.Transfer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class TransferParser implements Parser<String, List<Transfer>> {

    @Override
    public List<Transfer> parseData(String data) {

        LinkedList<Transfer> transfers = new LinkedList<>();

        try(BufferedReader reader = new BufferedReader(new StringReader(data))) {

            reader.lines().forEach(line -> {
                String[] parts = line.split(";");

                SimpleDateFormat date = new SimpleDateFormat("dd/mm/yyyy");

                try {

                    transfers.add(new Transfer(parts[0], parts[1], Double.parseDouble(parts[2]), date.parse(parts[3])));

                } catch (ParseException e){
                    e.printStackTrace();
                }

            });

        } catch (IOException e){
            e.printStackTrace();
        }

        return transfers;
    }

    @Override
    public String unparseData(List<Transfer> transfers) {

        StringBuilder builder = new StringBuilder();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");

        transfers.forEach(transfer -> {
            builder.append(transfer.getSender()).append(';');
            builder.append(transfer.getRecipient()).append(';');
            builder.append(transfer.getAmount()).append(';');
            builder.append(formatter.format(transfer.getDate())).append('\n');
        });

        return builder.toString();
    }
}
