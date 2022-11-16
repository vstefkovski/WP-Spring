package mk.ukim.finki.vp.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException{
    public InvalidUserCredentialsException(){
        super("Invalid user credidential exception");
    }
}
