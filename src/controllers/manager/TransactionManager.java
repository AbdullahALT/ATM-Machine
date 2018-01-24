package controllers.manager;

import model.Transaction;

import java.text.SimpleDateFormat;
import java.util.List;

public class TransactionManager extends DataManager<Transaction> {

    public TransactionManager(List<Transaction> list) {
        super(list);
    }

    @Override
    public Response update(Transaction updated) {
        return null;
    }

    @Override
    public Manager<Transaction> hold(List<Transaction> list) {
        return new TransactionManager(list);
    }

    @Override
    public void print() {
        System.out.printf("%-20s%s%n", "", "=-=-=-=-= Transaction Table =-=-=-=-=");
        System.out.printf("%-20s%-20s%-20s%-20s%s%n", "Transaction Type", "User Id", "Name", "Amount", "Date");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");

        getList().forEach(transfer ->
                System.out.printf("%-20s%-20s%-20s%-20s%-20s%n",
                        transfer.getType(),
                        transfer.getUserId(),
                        transfer.getUserName(),
                        transfer.getAmount(),
                        formatter.format(transfer.getDate())
                )
        );
    }
}
