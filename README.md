# API REST OneToOne

This Rest API developed in Spring Boot manages a database where there is information about users that are related to the purchase of a vehicle, only one user can access the purchase of a single vehicle; for this ration we use the OneToOne type, additionally we have access to the basic services of the Rest API: display, modify, create and delete through queries, the execution of which can be tested through an HTTP query software, the consumption of services from this API is done with Spring integrated software on the server.


#### URL for query for services
>
> - http://domain/api/customers/findAll
> - http://domain/api/customers/findById/id
> - http://domain/api/customers/save
> - http://domain/api/customers/update
> - http://domain/api/customers/delete
>
> - http://domain/api/cars/findAll
> - http://domain/api/cars/findById/id
> - http://domain/api/cars/save
> - http://domain/api/cars/update
> - http://domain/api/cars/delete


Service routing `<find all car>`

    
    @GetMapping("/findAll")
    public ResponseEntity<List<CustomerDTO>> findAll() {
        return new ResponseEntity<>(this.customerService.findAll(), HttpStatus.OK);
    }
    

Service routing `<Find car by id>`

    
    @GetMapping("/findById/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Integer id){
        return new ResponseEntity<>(this.customerService.findById(id), HttpStatus.OK);
    }
    

Service routing `<Save car>`

    
    @PostMapping("/save")
    public ResponseEntity<CustomerDTO> save(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(this.customerService.save(customerDTO), HttpStatus.CREATED);
    }
    

Service routing `<Update car>`

    
    @PutMapping("/updateById/{id}")
    public ResponseEntity<CustomerDTO> updateById(@PathVariable Integer id, @RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(this.customerService.updateById(id,customerDTO), HttpStatus.OK);
    }
    

Service routing `<Delete car>`

    
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        return new ResponseEntity<>(this.customerService.deleteById(id), HttpStatus.NO_CONTENT);
    }
    

#### Installation requirements

This API is supported in Java 21, therefore it is recommended to have the same or similar version.

For the database, this API only has a dependency for MySQL, therefore it is recommended that this be the database manager that is managed.

#### Versions
- Java version "21.0.2" 2024-01-16 LTS
- Spring Boot 3.4.2
- Maven technology
