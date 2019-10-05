package com.ashwinmulky.spring.nationality_predictor.resource;

import com.ashwinmulky.spring.nationality_predictor.service.NationalityPredictorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/nationality")
public class NationalityPredictorResource {

    @Autowired
    private NationalityPredictorService nationalityPredictorService;

    @GetMapping("/predict/{name}")
    public ResponseEntity<?> predictCountryByName(@PathVariable String name) {
        return new ResponseEntity<>(nationalityPredictorService.predictCountryByName(name), HttpStatus.OK);
    }
}
