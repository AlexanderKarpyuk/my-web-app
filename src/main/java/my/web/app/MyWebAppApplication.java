package my.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;

@SpringBootApplication
public class MyWebAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyWebAppApplication.class, args);
	}
}
