package mg.inclusiv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpGroupe3Application {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "application");
		SpringApplication.run(TpGroupe3Application.class, args);
	}

}
