package mk.ukim.finki.vp.service.impl;

import mk.ukim.finki.vp.model.User;
import mk.ukim.finki.vp.model.exceptions.InvalidArgumentException;
import mk.ukim.finki.vp.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.vp.model.exceptions.PasswordDoNotMatchException;
import mk.ukim.finki.vp.repository.InMemoryUserRepository;
import mk.ukim.finki.vp.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final InMemoryUserRepository userRepository;

    public AuthServiceImpl(InMemoryUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) throws InvalidArgumentException {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentException();
        }
        return userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) throws InvalidArgumentException, PasswordDoNotMatchException {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentException();
        }
        if (!password.equals(repeatPassword)) {
            throw new PasswordDoNotMatchException();
        }
        User user = new User(username, password, name, surname);
        return userRepository.saveForUpdate(user);
    }
}
