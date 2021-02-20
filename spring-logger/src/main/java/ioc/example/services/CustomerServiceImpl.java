package ioc.example.services;

import ioc.example.dto.CustomerDTO;
import ioc.example.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    private static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public String createCustomer(CustomerDTO dto) {
        return customerRepository.createCustomer(dto);
    }
    @Override
    public String fetchCustomer() {
        return customerRepository.fetchCustomer();
    }
    @Override
    public void deleteCustomer(long phoneNumber) {
        try {
            customerRepository.deleteCustomer(phoneNumber);
        } catch (Exception e) {
            logger.info("In log Exception ");
            logger.error(e.getMessage(),e);
        }
    }
}
