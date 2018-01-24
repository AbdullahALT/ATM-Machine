package model;

/**
 * Holds information about results of methods that may fail
 */
public class Response {

    private boolean isSuccess;
    private String message;

    public Response(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }
}
