package com.relationaldata.service.impl;

import com.relationaldata.persistence.dao.ICarDAO;
import com.relationaldata.persistence.entities.CarEntity;
import com.relationaldata.presentation.dto.CarDTO;
import com.relationaldata.service.ICarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private ICarDAO carDAO;

    @Override
    public List<CarDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return this.carDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, CarDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CarDTO findById(Integer id) {
        Optional<CarEntity> carEntity = this.carDAO.findById(id);

        if (carEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            CarEntity dtoCar = carEntity.get();
            return modelMapper.map(dtoCar, CarDTO.class);
        } else {
            return new CarDTO();
        }
    }

    @Override
    public CarDTO save(CarDTO carDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            CarEntity carEntity = modelMapper.map(carDTO, CarEntity.class);
            this.carDAO.save(carEntity);
            return carDTO;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error saving");
        }
    }

    @Override
    public CarDTO updateById(Integer id, CarDTO carDTO) {
        Optional<CarEntity> carEntity = this.carDAO.findById(id);

        if (carEntity.isPresent()) {
            CarEntity dtoCar = carEntity.get();
            dtoCar.setBrand(carDTO.getBrand());
            dtoCar.setModel(carDTO.getModel());
            dtoCar.setLicensePlate(carDTO.getLicensePlate());
            dtoCar.setPrice(carDTO.getPrice());
            this.carDAO.update(dtoCar);

            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(dtoCar, CarDTO.class);
        } else {
            throw new IllegalArgumentException("Error updating");
        }
    }

    @Override
    public String deleteById(Integer id) {
        Optional<CarEntity> carEntity = this.carDAO.findById(id);

        if (carEntity.isPresent()) {
            CarEntity dtoCar = carEntity.get();
            this.carDAO.delete(dtoCar);
            return "NO_CONTENT (This message will not be show)";
        } else {
            return "Error updating";
        }
    }
}