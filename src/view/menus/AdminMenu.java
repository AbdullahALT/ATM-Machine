package view.menus;

import model.MenuItem;

import java.util.LinkedList;
import java.util.List;

public class AdminMenu extends MenuScreen {


    public AdminMenu() {
        super("Admin Menu");
    }

    @Override
    protected List<MenuItem> initItems() {

        LinkedList<MenuItem> items = new LinkedList<>();
        items.add(new MenuItem("Create Account", state -> state.setCurrentScreen(state.getCreateAccountAction())));
        items.add(new MenuItem("Delete Account", state -> state.setCurrentScreen(state.getDeleteAccountAction())));
        items.add(new MenuItem("Search Account", state -> state.setCurrentScreen(state.getSearchAccountAction())));
        items.add(new MenuItem("Update Account", state -> state.setCurrentScreen(state.getUpdateAccountAction())));
        items.add(new MenuItem("Reports", state -> state.setCurrentScreen(state.getReports())));
        items.add(new MenuItem("Exit", state -> state.exit()));

        return items;
    }
}
