package ioc.example.config;

import ioc.example.services.EmployeeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public EmployeeServiceImpl employeeService(){
        return new EmployeeServiceImpl();
    }
}
