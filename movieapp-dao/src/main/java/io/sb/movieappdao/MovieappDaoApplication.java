package io.sb.movieappdao;

import io.sb.movieappdao.dao.CustomerDao;
import io.sb.movieapp.entity.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@SpringBootApplication
public class MovieappDaoApplication {



    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MovieappDaoApplication.class, args);
        CustomerDao customerDao = context.getBean(CustomerDao.class);
        Customer customer = new Customer();
        customer.setFirstName("Emma");
        customer.setLastName("Stone");
        customer.setUsername("emma123stone");
        customer.setPassword("emma@amme");
        customer.setDateOfBirth(LocalDateTime.of(1988, 11, 6, 0, 0));

        System.out.println("Before Saving: " + customer);

        Customer savedCustomer = customerDao.save(customer);
        System.out.println("After saving: " + savedCustomer);
/*
        Customer retrievedCustomer = customerDao.findById(savedCustomer.getCustomerId());
        System.out.println("After retrieving: " + retrievedCustomer);

        customer.setUsername("emmastone123");
        Customer updatedCustomer = customerDao.update(customer);
        System.out.println("After updating: " + updatedCustomer);

        customerDao.delete(updatedCustomer);
        System.out.println("After deleting: " + customerDao.findById(updatedCustomer.getCustomerId()));*/
    }

}
