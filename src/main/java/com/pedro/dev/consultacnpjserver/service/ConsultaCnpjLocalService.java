package com.pedro.dev.consultacnpjserver.service;

import com.pedro.dev.consultacnpjserver.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaCnpjLocalService {

    @Autowired
    EmpresaRepository empresaRepository;

}
