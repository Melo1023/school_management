package za.ac.cput.schoolmanagement.controller;

/*
    Student: Bongisa Mpahleni
    Student Number: 216205999
    Date: 9 June 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.service.lookup.AddressService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("school management/address/")
@Slf4j
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController (AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("save/")
    public ResponseEntity<Address> save (@Valid @RequestBody Address address) {
        log.info("Save request: {}", address);
        Address save = addressService.save(address);
        return ResponseEntity.ok(save);
    }

    private Optional<Address> getById(String staffId) {
        return this.addressService.read(staffId);
    }

    @GetMapping("read/{staffId}")
    public ResponseEntity<Address> read (@PathVariable String staffId) {
        log.info("Read request: {}", staffId);
        Address address = getById(staffId)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(address);
    }

    @DeleteMapping("delete/")
    public ResponseEntity<Void> delete (@PathVariable String staffId) {
        log.info("Read request: {}", staffId);
        this.addressService.deleteById(staffId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all/")
    public ResponseEntity<List<Address>> getALl(String staffId) {
        List<Address> addresses = this.addressService.getAll(staffId);
        return ResponseEntity.ok(addresses);
    }
}
