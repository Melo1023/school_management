/*
CityControllerTest.java
This is the city controller class
Author: Felecia Zweni
Date: 17/06/2022
 */

package za.ac.cput.schoolmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.lookup.City;
import za.ac.cput.schoolmanagement.service.lookup.CityService;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("school/city/")
@Slf4j
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController (CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("save")
    public ResponseEntity<City> save (@Valid @RequestBody City city) {
        log.info("Save request: {}", city);
        City save = cityService.save(city);
        return ResponseEntity.ok(save);
    }

    private Optional<City> getById(String id) {
        return this.cityService.read(id);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<City> read (@PathVariable String id) {
        log.info("Read request: {}", id);
        City city = getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(city);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Read request: {}", id);
        this.cityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<City>> getAll(String id) {
        List<City> cities = this.cityService.getAll(id);
        return ResponseEntity.ok(cities);
    }
}
