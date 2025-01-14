package com.relationaldata.presentation.controllers;

import com.relationaldata.presentation.dto.CustomerDTO;
import com.relationaldata.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    //Find all
    @GetMapping("/findAll")
    public ResponseEntity<List<CustomerDTO>> findAll() {
        return new ResponseEntity<>(this.customerService.findAll(), HttpStatus.OK);
    }

    //Find by id
    @GetMapping("/findById/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Integer id){
        return new ResponseEntity<>(this.customerService.findById(id), HttpStatus.OK);
    }

    //Save
    @PostMapping("/save")
    public ResponseEntity<CustomerDTO> save(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(this.customerService.save(customerDTO), HttpStatus.CREATED);
    }

    //Update
    @PutMapping("/updateById/{id}")
    public ResponseEntity<CustomerDTO> updateById(@PathVariable Integer id, @RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(this.customerService.updateById(id,customerDTO), HttpStatus.OK);
    }

    //Delete
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        return new ResponseEntity<>(this.customerService.deleteById(id), HttpStatus.NO_CONTENT);
    }

}