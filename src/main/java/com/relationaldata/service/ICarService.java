package com.relationaldata.service;

import com.relationaldata.presentation.dto.CarDTO;
import java.util.List;

public interface ICarService {
    List<CarDTO> findAll();
    CarDTO findById(Integer id);
    CarDTO save(CarDTO carDTO);
    CarDTO updateById(Integer id, CarDTO carDTO);
    String deleteById(Integer id);
}