package mk.ukim.finki.vp.service;

import mk.ukim.finki.vp.model.User;
import mk.ukim.finki.vp.model.exceptions.InvalidArgumentException;
import mk.ukim.finki.vp.model.exceptions.PasswordDoNotMatchException;

public interface AuthService {

    User login(String username, String password) throws InvalidArgumentException;

    User register(String username, String password, String repeatPassword, String name, String surname) throws InvalidArgumentException, PasswordDoNotMatchException;
}
