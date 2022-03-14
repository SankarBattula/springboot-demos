package io.sb.exceptionsvalidations.repository;


import io.sb.exceptionsvalidations.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<CustomerEntity, Integer> {
}
