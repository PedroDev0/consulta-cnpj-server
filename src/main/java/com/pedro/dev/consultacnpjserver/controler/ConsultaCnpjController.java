package com.pedro.dev.consultacnpjserver.controler;

import com.pedro.dev.consultacnpjserver.dto.CompanyInfo;
import com.pedro.dev.consultacnpjserver.service.ConsultaCnpjLocalService;
import com.pedro.dev.consultacnpjserver.service.ConsultaCnpjRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
public class ConsultaCnpjController {

    @Autowired
    ConsultaCnpjLocalService localService;

    @Autowired
    ConsultaCnpjRemoteService remoteService;

    @GetMapping()
    private ResponseEntity<CompanyInfo> getByCnpj(@RequestParam String cnpj) {
        return ResponseEntity.ok(remoteService.getCompanyInfoApi(cnpj));
    }


}
