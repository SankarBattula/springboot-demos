package io.sb.demoaop.service;

import io.sb.demoaop.dto.CustomerDTO;
import io.sb.demoaop.exception.RecordNotFoundException;

public interface CustomerService {
    /**
     * Saves customer personal details.
     * @param customerDTO
     * @return
     */
    public CustomerDTO saveCustomerData(CustomerDTO customerDTO);

    /**
     * Get a customer data using customer id.
     * @param customerId
     * @return
     */
    public CustomerDTO getCustomerData(int customerId) throws RecordNotFoundException;
}
