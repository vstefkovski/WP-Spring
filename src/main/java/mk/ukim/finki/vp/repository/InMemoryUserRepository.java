package mk.ukim.finki.vp.repository;

import mk.ukim.finki.vp.bootstrap.DataHolder;
import mk.ukim.finki.vp.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InMemoryUserRepository {
    public Optional<User> findByUsername(String username) {
        return DataHolder.users.stream()
                .filter(r -> r.getUsername().equals(username)).findFirst();
    }

    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return DataHolder.users.stream()
                .filter(r -> r.getUsername().equals(username) && r.getPassword().equals(password)).findFirst();
    }

    public User saveForUpdate(User user) {
        DataHolder.users.removeIf(r -> r.getUsername().equals(user.getUsername()));
        DataHolder.users.add(user);
        return user;
    }

    public void delete(String username) {
        DataHolder.users.removeIf(r -> r.getUsername().equals(username));
    }
}
