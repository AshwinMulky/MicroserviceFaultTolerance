package com.ashwinmulky.spring.gateway.service;

import com.ashwinmulky.spring.gateway.model.CountryDetails;
import com.ashwinmulky.spring.gateway.model.NationalityPredictorResponse;
import com.ashwinmulky.spring.gateway.service.vm.ResponseVM;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NationalityPredictorService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    //All these methods should be there in separate class like this to facilitate Hystrix to have proxy class

    @HystrixCommand(fallbackMethod = "getCountryDetailsFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public ResponseVM getCountryDetails(ResponseVM responseVM, NationalityPredictorResponse response) {
        response.getCountries().forEach(countryCode -> {
            CountryDetails countryDetails = webClientBuilder.build()
                    .get()
                    .uri("http://country-details/api/v1/country/" + countryCode)
                    .retrieve()
                    .bodyToMono(CountryDetails.class)
                    .block();
            responseVM.addCountryDetails(countryDetails);
        });
        return responseVM;
    }

    private ResponseVM getCountryDetailsFallback(ResponseVM responseVM, NationalityPredictorResponse response) {
        response.getCountries().forEach(countryCode -> {
            responseVM.addCountryDetails(new CountryDetails().setName(countryCode));
        });
        return responseVM;

    }

    @HystrixCommand(fallbackMethod = "getNationalityPredictorResponseFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public NationalityPredictorResponse getNationalityPredictorResponse(String name) {
        return webClientBuilder.build()
                .get()
                .uri("http://nationality-predictor/api/v1/nationality/predict/" + name)
                .retrieve()
                .bodyToMono(NationalityPredictorResponse.class)
                .block();
    }

    private NationalityPredictorResponse getNationalityPredictorResponseFallback(String name) {
        //send default response
        return new NationalityPredictorResponse()
                .setName(name);
    }
}
