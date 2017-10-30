package driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="controllers,services,model,repositories")
@EntityScan("model")  
@EnableJpaRepositories("repositories")
public class ApplicationMain {

	public static void main(String[] args) {
		System.out.println("Hello");
		SpringApplication.run(ApplicationMain.class, args);
		System.out.println("Hello");
	}
}
