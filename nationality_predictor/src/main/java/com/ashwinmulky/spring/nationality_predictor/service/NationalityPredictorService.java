package com.ashwinmulky.spring.nationality_predictor.service;

import com.ashwinmulky.spring.nationality_predictor.model.APIResponse;
import com.ashwinmulky.spring.nationality_predictor.service.vm.RespnseVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NationalityPredictorService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public RespnseVM predictCountryByName(String name) {
        APIResponse response = callAndGetExternalAPIResponse(name);
        RespnseVM respnseVM = new RespnseVM();
        respnseVM.setName(name);
        if(response != null) {
            response.getCountry().forEach(country -> {
                respnseVM.addCountry(country.getCountry_id());
            });
        }
        return respnseVM;
    }

        private APIResponse callAndGetExternalAPIResponse(String name) {
            return webClientBuilder.build()
                    .get()
                .uri("https://api.nationalize.io/?name=" + name)
                .retrieve()
                .bodyToMono(APIResponse.class)
                .block();
    }
}
