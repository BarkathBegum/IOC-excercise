package ioc.example.services;

import ioc.example.dto.CustomerDTO;
import ioc.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public String createCustomer(CustomerDTO customerDTO) {
        customerRepository.createCustomer(customerDTO);
        return "Customer with " + customerDTO.getPhoneNo() + " added successfully";
    }
    public List<CustomerDTO> fetchCustomer() {
        // uncomment the below line to see the AfterThrowing advice
        // int b=10/0;
        return customerRepository.fetchCustomer();
    }
    public String updateCustomer(long phoneNumber, CustomerDTO customerDTO) {
        return customerRepository.updateCustomer(phoneNumber, customerDTO);
    }
    public String deleteCustomer(long phoneNumber) throws Exception {
        return customerRepository.deleteCustomer(phoneNumber);
    }
}

