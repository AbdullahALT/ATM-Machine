package view;

import view.actions.*;
import view.menus.AdminMenu;
import view.menus.CustomerMenu;
import view.menus.ReportsMenu;
import view.menus.WithdrawCashMenu;

public class State {

    private Screen currentScreen;

    private Screen loginScreen = new LoginAction();

    private Screen customerMenu = new CustomerMenu();
    private Screen adminMenu = new AdminMenu();
    private Screen withdrawCashMenu = new WithdrawCashMenu();
    private Screen reports = new ReportsMenu();

    private Screen createAccountAction = new CreateAccountAction();
    private Screen deleteAccountAction = new DeleteAccountAction();
    private Screen updateAccountAction = new UpdateUserAction();
    private Screen searchAccountAction = new SearchAccountAction();
    private Screen balanceReportAction = new BalanceReportAction();
    private Screen dateReportAction = new DateReportAction();

    private Screen normalWithdrawAction = new NormalWithdrawAction();
    private Screen fastWithdrawAction = new FastWithdrawAction();
    private Screen cashTransfer = new CashTransferAction();
    private Screen depositCash = new DepositCashAction();
    private Screen displayBalance = new DisplayBalnceAction();
    private Screen printRecipe = new PrintRecipeAction();

    public State() {
        this.currentScreen = loginScreen;
    }

    public Screen getCurrentScreen() {
        return currentScreen;
    }

    public void exit(){
        System.exit(0);
    }

    public void setCurrentScreen(Screen screen){
        this.currentScreen = screen;
    }

    public Screen getLoginScreen() {
        return loginScreen;
    }

    public Screen getCustomerMenu() {
        return customerMenu;
    }

    public Screen getAdminMenu() {
        return adminMenu;
    }

    public Screen getWithdrawCashMenu() {
        return withdrawCashMenu;
    }

    public Screen getReports() {
        return reports;
    }

    public Screen getCreateAccountAction() {
        return createAccountAction;
    }

    public Screen getDeleteAccountAction() {
        return deleteAccountAction;
    }

    public Screen getUpdateAccountAction() {
        return updateAccountAction;
    }

    public Screen getSearchAccountAction() {
        return searchAccountAction;
    }

    public Screen getBalanceReportAction() {
        return balanceReportAction;
    }

    public Screen getDateReportAction() {
        return dateReportAction;
    }

    public Screen getNormalWithdrawAction() {
        return normalWithdrawAction;
    }

    public Screen getFastWithdrawAction() {
        return fastWithdrawAction;
    }

    public Screen getCashTransfer() {
        return cashTransfer;
    }

    public Screen getDepositCash() {
        return depositCash;
    }

    public Screen getDisplayBalance() {
        return displayBalance;
    }

    public Screen getPrintRecipe() {
        return printRecipe;
    }
}
