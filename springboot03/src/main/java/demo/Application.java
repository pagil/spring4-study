package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    @Autowired
    EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    private void init() {
        Employee employee = new Employee();
        employee.setFirstName("Bilbo");
        employee.setLastName("Baggins");
        employee.setTitle("thief");
        employeeRepository.save(employee);
    }
}
