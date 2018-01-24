package controllers;

public class Controller {

    public AdminController adminController;
    public CustomerController customerController;
    public AuthenticationController authenticationController;

    public Controller(AdminController adminController, CustomerController customerController, AuthenticationController authenticationController) {
        this.adminController = adminController;
        this.customerController = customerController;
        this.authenticationController = authenticationController;
    }

    public AdminController getAdminController() {
        return adminController;
    }

    public CustomerController getCustomerController() {
        return customerController;
    }

    public AuthenticationController getAuthenticationController() {
        return authenticationController;
    }
}
