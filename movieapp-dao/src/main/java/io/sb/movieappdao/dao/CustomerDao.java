package io.sb.movieappdao.dao;

import io.sb.movieapp.entity.Customer;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier
public interface CustomerDao {

    public Customer save(Customer customer);

    public Customer findById(int id);

    public Customer update(Customer customer);

    public void delete(Customer customer);
}