package com.relationaldata.persistence.dao;

import com.relationaldata.persistence.entities.CustomerEntity;
import java.util.List;
import java.util.Optional;

public interface ICustomersDAO {
    List<CustomerEntity> findAll();
    Optional<CustomerEntity> findById(Integer id);
    void save(CustomerEntity customerEntity);
    void update(CustomerEntity customerEntity);
    void delete(CustomerEntity customerEntity);
}
