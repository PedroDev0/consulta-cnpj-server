package com.pedro.dev.consultacnpjserver.service;

import com.pedro.dev.consultacnpjserver.config.ConfigService;
import com.pedro.dev.consultacnpjserver.constant.AdmKeys;
import com.pedro.dev.consultacnpjserver.dto.CompanyInfo;
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

    public CompanyInfo getCompanyInfoApi(String cnpj) {
        String url = configService.getConfig(AdmKeys.API_URL)+"office/"+ cnpj;

        ResponseEntity<CompanyInfo> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                getHeaders(),
                CompanyInfo.class);

        return response.getBody();
    }

    private HttpEntity<Void> getHeaders() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "d80c6b0e-bb48-493e-8d13-1c7df1779d34-583e08c9-5281-4121-a51f-4c95ad350e93");
        return new HttpEntity<>(headers);
    }

}
