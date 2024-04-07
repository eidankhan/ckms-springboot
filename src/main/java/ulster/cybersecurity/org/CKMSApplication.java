package ulster.cybersecurity.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CKMSApplication {

	public static void main(String[] args) {
		SpringApplication.run(CKMSApplication.class, args);
	}

	@GetMapping
	public String sayHello(){
		return "Application is running successfully !!!";
	}
}
