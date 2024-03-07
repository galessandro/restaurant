package com.granados;

import com.granados.customer.Customer;
import com.granados.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository){
        return args -> {
            Customer german = new Customer("German", "ggranados@gmail.com", 30);
            Customer marita = new Customer("Marita", "marita@gmail.com", 24);

            List<Customer> customers = List.of(german, marita);

            customerRepository.saveAll(customers);

        };
    }
}
