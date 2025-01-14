package com.relationaldata.service.impl;

import com.relationaldata.persistence.dao.ICustomersDAO;
import com.relationaldata.persistence.entities.CustomerEntity;
import com.relationaldata.presentation.dto.CustomerDTO;
import com.relationaldata.service.ICustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomersDAO customersDAO;

    @Override
    public List<CustomerDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return this.customersDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(Integer id) {
        Optional<CustomerEntity> customerEntity = this.customersDAO.findById(id);

        if (customerEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            CustomerEntity dtoCustomer = customerEntity.get();
            return modelMapper.map(dtoCustomer, CustomerDTO.class);
        } else {
            return new CustomerDTO();
        }
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            CustomerEntity customerEntity = modelMapper.map(customerDTO, CustomerEntity.class);
            this.customersDAO.save(customerEntity);
            return customerDTO;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error saving");
        }
    }

    @Override
    public CustomerDTO updateById(Integer id, CustomerDTO customerDTO) {
        Optional<CustomerEntity> customerEntity = this.customersDAO.findById(id);

        if (customerEntity.isPresent()) {
            CustomerEntity dtoCustomer = customerEntity.get();
            dtoCustomer.setName(customerDTO.getName());
            dtoCustomer.setLastName(customerDTO.getLastName());
            dtoCustomer.setIdDocument(customerDTO.getIdDocument());
            dtoCustomer.setPhoneNumber(customerDTO.getPhoneNumber());
            dtoCustomer.setEmail(customerDTO.getEmail());
            dtoCustomer.setCarRelation(customerDTO.getCarRelation());
            this.customersDAO.update(dtoCustomer);

            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(dtoCustomer, CustomerDTO.class);
        } else {
            throw new IllegalArgumentException("Error updating");
        }
    }

    @Override
    public String deleteById(Integer id) {
        Optional<CustomerEntity> customerEntity = this.customersDAO.findById(id);

        if (customerEntity.isPresent()) {
            CustomerEntity dtoCustomer = customerEntity.get();
            this.customersDAO.delete(dtoCustomer);
            return "NO_CONTENT (This message will not be show)";
        } else {
            return "Error updating";
        }
    }
}