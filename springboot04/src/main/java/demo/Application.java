package demo;

import demo.orika.test.domain.Person;
import demo.orika.test.spring.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Application {


    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        PersonService personService = context.getBean(PersonService.class);
        Person person = personService.obtainPersion();
        System.out.println(person);
    }


}
