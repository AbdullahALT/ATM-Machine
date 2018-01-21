package view.menus;

import model.MenuItem;

import java.util.LinkedList;
import java.util.List;

public class ReportsMenu extends MenuScreen {

    public ReportsMenu() {
        super("Reports");
    }

    @Override
    protected List<MenuItem> initItems() {
        LinkedList<MenuItem> items = new LinkedList<>();
        items.add(new MenuItem("Balance Report", state -> state.setCurrentScreen(state.getBalanceReportAction())));
        items.add(new MenuItem("Date Report", state -> state.setCurrentScreen(state.getDateReportAction())));
        items.add(new MenuItem("Exit", state -> state.exit()));

        return items;
    }
}
