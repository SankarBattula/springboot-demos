package io.sb.exceptionsvalidations.service;

import io.sb.exceptionsvalidations.dto.CustomerDTO;
import io.sb.exceptionsvalidations.exception.RecordNotFoundException;

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
