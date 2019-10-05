package com.ashwinmulky.spring.country_details.service;

import com.ashwinmulky.spring.country_details.service.vm.CountryDetailsVM;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@Service
public class CountryDetailsService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private ObjectMapper objectMapper;

    public CountryDetailsVM getCountryDetails(String id) throws IOException {
        String respnseJSON = webClientBuilder.build()
                .get()
                .uri("https://restcountries.eu/rest/v2/alpha/" + id)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        //objectMapper.configure(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY, true);
        return objectMapper.readValue(respnseJSON, CountryDetailsVM.class);
    }
}
