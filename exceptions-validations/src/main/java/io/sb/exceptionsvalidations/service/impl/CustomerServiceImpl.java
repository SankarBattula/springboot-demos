package io.sb.exceptionsvalidations.service.impl;


import io.sb.exceptionsvalidations.dto.CustomerDTO;
import io.sb.exceptionsvalidations.entity.CustomerEntity;
import io.sb.exceptionsvalidations.exception.RecordNotFoundException;
import io.sb.exceptionsvalidations.mapper.CustomerMapper;
import io.sb.exceptionsvalidations.repository.CustomerRepo;
import io.sb.exceptionsvalidations.service.CustomerService;
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
