package com.pedro.dev.consultacnpjserver.controller;

import com.pedro.dev.consultacnpjserver.dto.request.CompanyInfo;
import com.pedro.dev.consultacnpjserver.dto.response.EmpresaInfoDto;
import com.pedro.dev.consultacnpjserver.service.ConsultaCnpjLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
public class ConsultaCnpjController {

    @Autowired
    ConsultaCnpjLocalService localService;

    @GetMapping
    private ResponseEntity<EmpresaInfoDto> getByCnpj(@RequestParam("cnpj") String cnpj) {
        return ResponseEntity.ok(localService.findByCnpj(cnpj));
    }


}
