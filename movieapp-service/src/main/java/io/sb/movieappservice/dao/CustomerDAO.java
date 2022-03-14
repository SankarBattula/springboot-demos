package io.sb.movieappservice.dao;

import io.sb.movieappservice.entities.Customer;


public interface CustomerDAO {

  public Customer save(Customer customer);

  public Customer findById(int id);

  public Customer update(Customer customer);

  public void delete(Customer customer);
}
