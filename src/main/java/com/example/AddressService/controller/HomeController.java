package com.example.AddressService.controller;

import com.example.AddressService.Repository.AddressRepo;
import com.example.AddressService.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Address")
public class HomeController {

    @Autowired
    private AddressRepo repo;

    @PostMapping
    public ResponseEntity<String> saveAddress(@RequestBody Address address) {
        Address addr = repo.save(address);
        String res = "Address have saved successfull With ID : "+addr.getAddressId();
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAddress() {
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }
}
