package com.example.springlocalidade.service;

import com.example.springlocalidade.model.Cidade;
import com.example.springlocalidade.model.Estado;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class IbgeService {

    private final String IBGE_API_URL;

    public IbgeService() {
        // Obtenha a URL base da configuração
        IBGE_API_URL = IbgeApiConfig.getBaseUrl();
    }

    public List<Estado> listarEstados() {
        String estadosUrl = IBGE_API_URL + "estados";

        ResponseEntity<Estado[]> responseEntity = new RestTemplate().getForEntity(estadosUrl, Estado[].class);
        Estado[] estados = responseEntity.getBody();

        return Arrays.asList(estados);
    }

    public List<Cidade> listarCidadesPorEstado(String estadoId) {
        String cidadesUrl = IBGE_API_URL + "estados/" + estadoId + "/municipios";

        ResponseEntity<Cidade[]> responseEntity = new RestTemplate().getForEntity(cidadesUrl, Cidade[].class);
        Cidade[] cidades = responseEntity.getBody();

        return Arrays.asList(cidades);
    }

    // Outros métodos conforme necessário

}
