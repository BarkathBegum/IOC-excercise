package ioc.example.services;

import ioc.example.dto.CustomerDTO;

public interface CustomerService {
    public String createCustomer(CustomerDTO dto);
    public String fetchCustomer();
    public void deleteCustomer(long phoneNumber) throws Exception;
}
