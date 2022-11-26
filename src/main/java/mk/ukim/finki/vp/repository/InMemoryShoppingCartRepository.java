package mk.ukim.finki.vp.repository;

import mk.ukim.finki.vp.bootstrap.DataHolder;
import mk.ukim.finki.vp.model.ShoppingCart;
import mk.ukim.finki.vp.model.User;
import mk.ukim.finki.vp.model.enumerations.ShoppingCartStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InMemoryShoppingCartRepository {

    public Optional<ShoppingCart> findById(Long id) {
        return DataHolder.shoppingCarts.stream()
                .filter(r -> r.getId().equals(id)).findFirst();
    }

    public Optional<ShoppingCart> findByUsernameAndStatus(String username, ShoppingCartStatus status) {
        return DataHolder.shoppingCarts.stream()
                .filter(r -> r.getUser().getUsername().equals(username)
                        && r.getStatus().equals(status)).findFirst();
    }

    public ShoppingCart save(ShoppingCart shoppingCart) {
        DataHolder.shoppingCarts
                .removeIf(r -> r.getUser()
                        .getUsername()
                        .equals(shoppingCart.getUser().getUsername()));
        DataHolder.shoppingCarts.add(shoppingCart);
        return shoppingCart;
    }


}
