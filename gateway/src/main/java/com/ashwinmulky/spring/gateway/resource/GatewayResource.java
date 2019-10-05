package com.ashwinmulky.spring.gateway.resource;

import com.ashwinmulky.spring.gateway.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gateway/api/v1/predict")
public class GatewayResource {

    @Autowired
    private GatewayService gatewayService;

    @GetMapping("/{name}")
    public ResponseEntity<?> predictNationalityAndCountryDetails(@PathVariable String name) {
        return new ResponseEntity<>(gatewayService.predict(name), HttpStatus.OK);
    }
}
