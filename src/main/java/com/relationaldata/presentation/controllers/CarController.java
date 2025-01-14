package com.relationaldata.presentation.controllers;

import com.relationaldata.presentation.dto.CarDTO;
import com.relationaldata.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/cars")
public class CarController {

    @Autowired
    private ICarService carService;

    //Find all
    @GetMapping("/findAll")
    public ResponseEntity<List<CarDTO>> findAll() {
        return new ResponseEntity<>(this.carService.findAll(), HttpStatus.OK);
    }

    //Find car by id
    @GetMapping("/findById/{id}")
    public ResponseEntity<CarDTO> findById(@PathVariable Integer id){
        return new ResponseEntity<>(this.carService.findById(id), HttpStatus.OK);
    }

    //Save car
    @PostMapping("/save")
    public ResponseEntity<CarDTO> save(@RequestBody CarDTO carDTO){
        return new ResponseEntity<>(this.carService.save(carDTO), HttpStatus.CREATED);
    }

    //Update car
    @PutMapping("/updateById/{id}")
    public ResponseEntity<CarDTO> updateById(@PathVariable Integer id, @RequestBody CarDTO carDTO){
        return new ResponseEntity<>(this.carService.updateById(id,carDTO), HttpStatus.OK);
    }

    //Delete user
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        return new ResponseEntity<>(this.carService.deleteById(id), HttpStatus.NO_CONTENT);
    }

}