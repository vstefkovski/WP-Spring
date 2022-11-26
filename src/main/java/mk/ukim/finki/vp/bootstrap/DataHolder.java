package mk.ukim.finki.vp.bootstrap;

import lombok.Getter;
import mk.ukim.finki.vp.model.Category;
import mk.ukim.finki.vp.model.Manufacturer;
import mk.ukim.finki.vp.model.Product;
import mk.ukim.finki.vp.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static List<Category> categories = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();

    @PostConstruct
    public void init(){
        categories.add(new Category("Movies", "Movies category"));
        categories.add(new Category("Books", "Books category"));
        categories.add(new Category("Software", "Software category"));

        users.add(new User("vojdan.stefkovski", "pass", "vojdan", "stefkovski"));
        users.add(new User("kiko.vojceski", "pass", "kiko", "vojceski"));

        Manufacturer manufacturer = new Manufacturer("Nike", "NY NY");
        manufacturers.add(manufacturer);

        Category category = new Category("Sport", "Sport category");
        categories.add(category);

        products.add(new Product("Ball", 235.8, 7, category, manufacturer));
        products.add(new Product("Ball 2", 235.8, 7, category, manufacturer));
        products.add(new Product("Ball 3", 235.8, 7, category, manufacturer));

    }
}
