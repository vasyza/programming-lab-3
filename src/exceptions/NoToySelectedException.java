package exceptions;

public final class NoToySelectedException extends RuntimeException {
    public NoToySelectedException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "NoToySelectedException: " + super.getMessage();
    }
}