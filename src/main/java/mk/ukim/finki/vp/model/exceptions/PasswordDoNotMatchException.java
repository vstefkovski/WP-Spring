package mk.ukim.finki.vp.model.exceptions;

public class PasswordDoNotMatchException extends RuntimeException {
    public PasswordDoNotMatchException() {
        super("Passwords do not match.");
    }
}
