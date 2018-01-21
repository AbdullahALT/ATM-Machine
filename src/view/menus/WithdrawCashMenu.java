package view.menus;

import model.MenuItem;

import java.util.LinkedList;
import java.util.List;

public class WithdrawCashMenu extends MenuScreen {

    public WithdrawCashMenu() {
        super("Withdraw Cash Menu");
    }

    @Override
    protected List<MenuItem> initItems() {

        LinkedList<MenuItem> items = new LinkedList<>();
        items.add(new MenuItem("Fast Cash", state -> state.setCurrentScreen(state.getFastWithdrawAction())));
        items.add(new MenuItem("Normal Cash", state -> state.setCurrentScreen(state.getNormalWithdrawAction())));
        items.add(new MenuItem("Exit", state -> state.exit()));

        return items;
    }
}
