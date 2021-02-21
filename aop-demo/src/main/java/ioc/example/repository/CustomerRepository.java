package ioc.example.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import ioc.example.dto.CustomerDTO;

import javax.annotation.PostConstruct;

@Repository
public class CustomerRepository {
    @PostConstruct
    public void initializer()
    {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setAddress("Chennai");
        customerDTO.setName("Barkath");
        customerDTO.setEmail("Barkath@infy.com");
        customerDTO.setPhoneNo(978982213);
        customers = new ArrayList<>();
        customers.add(customerDTO);
    }
    List <CustomerDTO> customers=null;
    public String createCustomer(CustomerDTO dto) {
        customers = new ArrayList<>();
        customers.add(dto);
        return "Customer added successfully"+customers.indexOf(dto);
    }
    public List<CustomerDTO> fetchCustomer()  {
        return customers;
    }
    public String deleteCustomer(long phoneNumber) throws Exception
    {
        String response = "Customer of :"+phoneNumber+"\t does not exist";
        for(CustomerDTO customer : customers)
        {
            if(customer.getPhoneNo() == phoneNumber)
            {
                customers.remove(customer);
                response=customer.getName()+"of phoneNumber"+customer.getPhoneNo()+"\t got deleted successfully";
                break;
            }

        }
        return response;
    }
    // updates customer
    public String updateCustomer(long phoneNumber, CustomerDTO customerDTO) {
        String response = "Customer of:" + phoneNumber + "\t does not exist";
        for (CustomerDTO customer : customers) {
            if (customer.getPhoneNo() == phoneNumber) {
                if (customerDTO.getName() != null)
                    customer.setName(customerDTO.getName());
                if (customerDTO.getAddress() != null)
                    customer.setAddress(customerDTO.getAddress());
                customers.set(customers.indexOf(customer), customer);
                response = "Customer of phoneNumber" + customer.getPhoneNo() + "\t got updated successfully";
                break;
            }
        }
        return response;
    }
}
