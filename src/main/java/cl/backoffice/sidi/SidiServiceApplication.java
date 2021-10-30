package cl.backoffice.sidi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource(value = "{file:${user.home}${file.separator}properties${file.separator}sidi-service.properties}")
public class SidiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SidiServiceApplication.class, args);
	}

}
