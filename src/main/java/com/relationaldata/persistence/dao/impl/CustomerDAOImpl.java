package com.relationaldata.persistence.dao.impl;

import com.relationaldata.persistence.dao.ICustomersDAO;
import com.relationaldata.persistence.entities.CustomerEntity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDAOImpl implements ICustomersDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<CustomerEntity> findAll() {
        var query = this.entityManager.createNativeQuery("SELECT * FROM tb_customers",CustomerEntity.class);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CustomerEntity> findById(Integer id) {
        return Optional.ofNullable(this.entityManager.find(CustomerEntity.class,id));
    }

    @Override
    @Transactional
    public void save(CustomerEntity customerEntity) {
        this.entityManager.persist(customerEntity);
        this.entityManager.flush();
    }

    @Override
    @Transactional
    public void update(CustomerEntity customerEntity) {
        this.entityManager.merge(customerEntity);
    }

    @Override
    @Transactional
    public void delete(CustomerEntity customerEntity) {
        this.entityManager.remove(customerEntity);
    }
}