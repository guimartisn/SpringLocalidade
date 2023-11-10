package com.example.springlocalidade.service;

public class IbgeApiConfig {

    private static final String BASE_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/";

    public static String getBaseUrl() {
        return BASE_URL;
    }
}
