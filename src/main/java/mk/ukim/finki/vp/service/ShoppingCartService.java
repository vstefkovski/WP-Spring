package mk.ukim.finki.vp.service;

import mk.ukim.finki.vp.model.Product;
import mk.ukim.finki.vp.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<Product> listAllProductsInShoppingCart(Long cartId);

    ShoppingCart getActiveShoppingCart(String username);

    ShoppingCart addProductToShoppingCart(String username, Long productId);

}
