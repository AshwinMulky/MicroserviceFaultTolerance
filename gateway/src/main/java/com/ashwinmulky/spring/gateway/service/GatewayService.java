package com.ashwinmulky.spring.gateway.service;

import com.ashwinmulky.spring.gateway.model.NationalityPredictorResponse;
import com.ashwinmulky.spring.gateway.service.vm.ResponseVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GatewayService {

    @Autowired
    private NationalityPredictorService nationalityPredictorService;

    public ResponseVM predict(String name) {
        ResponseVM responseVM = new ResponseVM();
        NationalityPredictorResponse response = nationalityPredictorService.getNationalityPredictorResponse(name);

        if(response != null) {
            responseVM = nationalityPredictorService.getCountryDetails(responseVM, response);
        }
        responseVM.setName(name);
        return responseVM;
    }
}
