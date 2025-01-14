package com.relationaldata.service;

import com.relationaldata.presentation.dto.CustomerDTO;
import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> findAll();
    CustomerDTO findById(Integer id);
    CustomerDTO save(CustomerDTO customerDTO);
    CustomerDTO updateById(Integer id, CustomerDTO customerDTO);
    String deleteById(Integer id);
}