package mk.ukim.finki.vp.bootstrap;

import lombok.Getter;
import mk.ukim.finki.vp.model.Category;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static List<Category> categories = new ArrayList<>();

    @PostConstruct
    public void init(){
        categories.add(new Category("Movies", "Movies category"));
        categories.add(new Category("Books", "Books category"));
        categories.add(new Category("Software", "Software category"));

    }
}
