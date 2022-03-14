package io.sb.demoaop.controller;

import io.sb.demoaop.dto.CustomerDTO;
import io.sb.demoaop.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/customerApi")
public class CustomerController {

    private static Logger LOGGER = (Logger) LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping("/live")
    public Object checkStatus() {
        LOGGER.info("Inside checkStatus");
        return ResponseEntity.ok().body("Customer service is up and running fine.");
    }

    @PostMapping("/v1/customer")
    public ResponseEntity<CustomerDTO> saveCustomer(
             @RequestBody CustomerDTO customerDTO) {
        CustomerDTO response = customerService.saveCustomerData(customerDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v1/customer/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomer(
            @PathVariable int customerId) {
        CustomerDTO customerDTO = customerService.getCustomerData(customerId);
        return ResponseEntity.ok(customerDTO);
    }
}