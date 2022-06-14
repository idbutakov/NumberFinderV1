package org.exapmle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@SpringBootApplication
@EnableJpaRepositories
public class RestServiceApplication implements RepositoryRestConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }
}
