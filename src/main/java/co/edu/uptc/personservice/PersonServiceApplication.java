package co.edu.uptc.personservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "co.edu.uptc.personservice.repository")
@EntityScan(basePackages = "co.edu.uptc.personservice.model")
public class PersonServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(PersonServiceApplication.class, args);
    }

}
