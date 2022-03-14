package io.sb.demoaop.repository;

import io.sb.demoaop.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<CustomerEntity, Integer> {
}
