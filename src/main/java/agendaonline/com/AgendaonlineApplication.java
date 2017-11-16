package agendaonline.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AgendaonlineApplication {//deve estar no diretorio raiz.

	public static void main(String[] args) {
		SpringApplication.run(AgendaonlineApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("456"));
	}
}
