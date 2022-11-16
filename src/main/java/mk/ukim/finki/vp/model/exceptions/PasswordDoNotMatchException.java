package mk.ukim.finki.vp.model.exceptions;

public class PasswordDoNotMatchException extends Exception {
    public PasswordDoNotMatchException() {
        super("Passwords do not match.");
    }
}
