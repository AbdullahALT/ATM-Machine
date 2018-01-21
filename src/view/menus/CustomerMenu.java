package view.menus;

import model.MenuItem;

import java.util.LinkedList;
import java.util.List;

public class CustomerMenu extends MenuScreen {

    public CustomerMenu() {
        super("Customer Menu");
    }

    @Override
    protected List<MenuItem> initItems() {

        LinkedList<MenuItem> items = new LinkedList<>();
        items.add(new MenuItem("Withdraw Cash", state -> state.setCurrentScreen(state.getWithdrawCashMenu())));
        items.add(new MenuItem("Cash Transfer", state -> state.setCurrentScreen(state.getCashTransfer())));
        items.add(new MenuItem("Deposit Cash", state -> state.setCurrentScreen(state.getDepositCash())));
        items.add(new MenuItem("Display Balance", state -> state.setCurrentScreen(state.getDisplayBalance())));
        items.add(new MenuItem("Exit", state -> state.exit()));

        return items;
    }
}
