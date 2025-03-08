package com.pedro.dev.consultacnpjserver.service;

import com.pedro.dev.consultacnpjserver.dto.request.CompanyInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ConsultaCnpjRemoteService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    @Value("${api.url}")
    private String url;

    private static final Logger logger = LoggerFactory.getLogger(ConsultaCnpjRemoteService.class);

    public CompanyInfo getCompanyInfoApi(String cnpj) {

        url = url + "office/" + cnpj;
        logger.info("url " + url);

        ResponseEntity<CompanyInfo> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                getHeaders(),
                CompanyInfo.class);

        return response.getBody();
    }

    private HttpEntity<Void> getHeaders() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", apiKey);
        return new HttpEntity<>(headers);
    }

}
