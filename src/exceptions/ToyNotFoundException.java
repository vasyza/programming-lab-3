package exceptions;

public final class ToyNotFoundException extends Exception {
    public ToyNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "ToyNotFoundException: " + super.getMessage();
    }
}
