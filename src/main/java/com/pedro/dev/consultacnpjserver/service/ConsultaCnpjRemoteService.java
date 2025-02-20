package com.pedro.dev.consultacnpjserver.service;

import com.pedro.dev.consultacnpjserver.config.ConfigService;
import com.pedro.dev.consultacnpjserver.constant.AdmKeys;
import com.pedro.dev.consultacnpjserver.dto.CompanyInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ConsultaCnpjRemoteService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ConfigService configService;

    private static final Logger logger = LoggerFactory.getLogger(ConsultaCnpjRemoteService.class);

    public CompanyInfo getCompanyInfoApi(String cnpj) {
        String url = configService.getConfig(AdmKeys.API_URL)+"office/"+ cnpj;

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
        headers.set("Authorization", "");
        return new HttpEntity<>(headers);
    }

}
