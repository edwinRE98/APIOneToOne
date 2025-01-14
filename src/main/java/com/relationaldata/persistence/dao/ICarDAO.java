package com.relationaldata.persistence.dao;

import com.relationaldata.persistence.entities.CarEntity;
import java.util.List;
import java.util.Optional;

public interface ICarDAO {
    List<CarEntity> findAll();
    Optional<CarEntity> findById(Integer id);
    void save(CarEntity car);
    void update(CarEntity car);
    void delete(CarEntity car);
}
