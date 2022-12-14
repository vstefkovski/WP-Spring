package mk.ukim.finki.vp.service.impl;

import mk.ukim.finki.vp.model.Product;
import mk.ukim.finki.vp.model.ShoppingCart;
import mk.ukim.finki.vp.model.User;
import mk.ukim.finki.vp.model.enumerations.ShoppingCartStatus;
import mk.ukim.finki.vp.model.exceptions.ProductAlreadyInShoppingCartException;
import mk.ukim.finki.vp.model.exceptions.ProductNotFoundException;
import mk.ukim.finki.vp.model.exceptions.ShoppingCartNotFoundException;
import mk.ukim.finki.vp.model.exceptions.UserNotFoundException;
import mk.ukim.finki.vp.repository.InMemoryShoppingCartRepository;
import mk.ukim.finki.vp.repository.InMemoryUserRepository;
import mk.ukim.finki.vp.service.ProductService;
import mk.ukim.finki.vp.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final InMemoryShoppingCartRepository shoppingCartRepository;
    private final InMemoryUserRepository userRepository;
    private final ProductService productService;

    public ShoppingCartServiceImpl(InMemoryShoppingCartRepository shoppingCartRepository, InMemoryUserRepository userRepository, ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.productService = productService;
    }

    @Override
    public List<Product> listAllProductsInShoppingCart(Long cartId) {
        if (!this.shoppingCartRepository.findById(cartId).isPresent())
            throw new ShoppingCartNotFoundException(cartId);
        return this.shoppingCartRepository.findById(cartId).get().getProducts();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        return this.shoppingCartRepository
                .findByUsernameAndStatus(username, ShoppingCartStatus.CREATED)
                .orElseGet(() -> {
                    User user = this.userRepository.findByUsername(username)
                            .orElseThrow(() -> new UserNotFoundException(username));
                    ShoppingCart shoppingCart = new ShoppingCart(user);
                    return this.shoppingCartRepository.save(shoppingCart);
                });
    }

    @Override
    public ShoppingCart addProductToShoppingCart(String username, Long productId) {
        ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
        Product product = this.productService.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
        if (shoppingCart.getProducts().stream()
                .filter(r -> r.getId().equals(productId))
                .collect(Collectors.toList()).size() > 0)
            throw new ProductAlreadyInShoppingCartException(productId, username);
        shoppingCart.getProducts().add(product);
        return this.shoppingCartRepository.save(shoppingCart);
    }
}
