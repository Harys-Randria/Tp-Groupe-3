package mg.fertilize.tp_qualimetrie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"mg.fertilize.tp_qualimetrie.entity"})
public class TpQualimetrieApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpQualimetrieApplication.class, args);
	}

}
