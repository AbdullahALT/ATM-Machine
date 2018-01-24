package controllers;

/**
 * Holds the application's controllers in one object, a lazy simulation of the Context Design Pattern
 */
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
