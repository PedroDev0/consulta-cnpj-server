package com.pedro.dev.consultacnpjserver.controler;

import com.pedro.dev.consultacnpjserver.service.ConsultaCnpjLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cnpj")
public class ConsultaCnpjController {

    @Autowired
    ConsultaCnpjLocalService service;
}
