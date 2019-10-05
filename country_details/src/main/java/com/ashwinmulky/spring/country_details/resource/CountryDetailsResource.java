package com.ashwinmulky.spring.country_details.resource;

import com.ashwinmulky.spring.country_details.service.CountryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/country")
public class CountryDetailsResource {

    @Autowired
    private CountryDetailsService countryDetailsService;

    @GetMapping("{id}")
    public ResponseEntity<?> getCountryDetails(@PathVariable String id) {
        try {
            return new ResponseEntity<>(countryDetailsService.getCountryDetails(id),HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
