package io.sb.demoaop.service.impl;

import io.sb.demoaop.dto.CustomerDTO;
import io.sb.demoaop.entity.CustomerEntity;
import io.sb.demoaop.exception.RecordNotFoundException;
import io.sb.demoaop.mapper.CustomerMapper;
import io.sb.demoaop.repository.CustomerRepo;
import io.sb.demoaop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public CustomerDTO saveCustomerData(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = CustomerMapper.convertDTOToEntity(customerDTO);
        customerEntity = customerRepo.save(customerEntity);
        CustomerDTO customerDTOResponse = CustomerMapper.convertEntityToDTO(customerEntity);
        return customerDTOResponse;
    }

    @Override
    public CustomerDTO getCustomerData(int customerId) throws RecordNotFoundException {
        CustomerEntity customerEntity =
                customerRepo.findById(customerId)
                        .orElseThrow(() -> new RecordNotFoundException("Customer details for customer[" + customerId + "] does not exist"));
        CustomerDTO customerDTO = CustomerMapper.convertEntityToDTO(customerEntity);
        return customerDTO;
    }
}
