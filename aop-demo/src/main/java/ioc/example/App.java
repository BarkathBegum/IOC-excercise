package ioc.example;

import ioc.example.services.CustomerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
                CustomerServiceImpl service = null;
                AbstractApplicationContext context = (AbstractApplicationContext) SpringApplication.run(App.class,
                        args);

                service = (CustomerServiceImpl) context.getBean("customerService");
                //service.deleteCustomer(1151212222l);
                 service.fetchCustomer();
                 context.close();
    }
}
