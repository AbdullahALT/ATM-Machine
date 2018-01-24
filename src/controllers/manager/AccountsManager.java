package controllers.manager;

import model.Account;
import model.Response;

import java.util.List;

public class AccountsManager extends DataManager<Account> {

    public AccountsManager(List<Account> list) {
        super(list);
    }

    @Override
    public Response insert(Account data) {
        data.setUserId(newID());
        data.setAccountId(newID());
        return super.insert(data);
    }

    @Override
    public Response update(Account updated) {

        getList().replaceAll(account -> {

            if(account.getUserId() == updated.getUserId()){
                account.setStatus(updated.getStatus());
                account.setBalance(updated.getBalance());
                account.setName(updated.getName());
                account.setType(updated.getType());
            }

            return account;
        });

        return new Response(true, "The Account has been Updated Successfully.");
    }

    @Override
    public void print() {
        System.out.printf("%-20s%s%n","", "=-=-=-=-= Account Table =-=-=-=-=");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%s%n", "Account ID", "User ID", "Holder's Name","Type", "Balance", "Status");
        getList().forEach(account ->
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%n",
                    account.getAccountId(),
                    account.getUserId(),
                    account.getName(),
                    account.getType(),
                    account.getBalance(),
                    account.getStatus()
                    )
        );
    }

    @Override
    public Manager<Account> hold(List<Account> list) {
        return new AccountsManager(list);
    }

    private int newID() {
        if(getList().size() == 0)
            return 1;

        Account last = getList().get(getList().size() - 1);

        return last.getUserId() + 1;
    }
}
