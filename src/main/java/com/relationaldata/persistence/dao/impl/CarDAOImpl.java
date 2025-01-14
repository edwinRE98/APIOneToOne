package com.relationaldata.persistence.dao.impl;

import com.relationaldata.persistence.dao.ICarDAO;
import com.relationaldata.persistence.entities.CarEntity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class CarDAOImpl implements ICarDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<CarEntity> findAll() {
        var query = this.entityManager.createNativeQuery("SELECT * FROM tb_cars",CarEntity.class);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CarEntity> findById(Integer id) {
        return Optional.ofNullable(this.entityManager.find(CarEntity.class,id));
    }

    @Override
    @Transactional
    public void save(CarEntity car) {
        this.entityManager.persist(car);
        this.entityManager.flush();
    }

    @Override
    @Transactional
    public void update(CarEntity car) {
        this.entityManager.merge(car);
    }

    @Override
    @Transactional
    public void delete(CarEntity car) {
        this.entityManager.remove(car);
    }
}