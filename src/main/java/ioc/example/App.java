package ioc.example;

import ioc.example.config.SpringConfig;
import ioc.example.dto.EmployeeDTO;
import ioc.example.services.EmployeeServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EmployeeServiceImpl employeeService = null;
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        employeeService = (EmployeeServiceImpl) context.getBean("employeeService");
        employeeService.insert(new EmployeeDTO(101,"Barkath","Research Tech"));
        employeeService.delete(101);

    }
}
