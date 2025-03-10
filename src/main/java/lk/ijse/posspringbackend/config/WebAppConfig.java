package lk.ijse.posspringbackend.config;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse.posspringbackend")
@EnableJpaRepositories(basePackages = "lk.ijse.posspringbackend")
@EnableTransactionManagement
@EnableWebMvc
public class WebAppConfig {
}
