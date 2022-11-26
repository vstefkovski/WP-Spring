package mk.ukim.finki.vp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

@ServletComponentScan
@SpringBootApplication
public class VpApplication {

    public static void main(String[] args) {
        SpringApplication.run(VpApplication.class, args);
    }


}
