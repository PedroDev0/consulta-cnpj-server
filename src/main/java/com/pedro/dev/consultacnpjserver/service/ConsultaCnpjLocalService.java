package com.pedro.dev.consultacnpjserver.service;

import com.pedro.dev.consultacnpjserver.dto.request.CompanyInfo;
import com.pedro.dev.consultacnpjserver.dto.response.EmpresaInfoDto;
import com.pedro.dev.consultacnpjserver.mappper.EmpresaMapper;
import com.pedro.dev.consultacnpjserver.model.Empresa;
import com.pedro.dev.consultacnpjserver.repository.EmpresaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultaCnpjLocalService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private ConsultaCnpjRemoteService remoteService;

    private static final Logger logger = LoggerFactory.getLogger(ConsultaCnpjLocalService.class);

    private final EmpresaMapper empresaMapper = new EmpresaMapper();

    public EmpresaInfoDto findByCnpj(String cnpj) {
        logger.info("Iniciando consulta local");
        Optional<Empresa> empresaOP = empresaRepository.findByCnpj(cnpj);

        logger.info("Verificando se existe a empresa");
        if (empresaOP.isPresent()) {
            logger.info("Empresa existente local");
            return empresaMapper.toEmpresaInfoDto(empresaOP.get());
        }

        logger.info("Emperesa inexistente");
        logger.info("Buscando via api");

        CompanyInfo companyInfo = remoteService.getCompanyInfoApi(cnpj);

        logger.info("Convertendo dados da api para salvar no banco");
        Empresa empresa = empresaMapper.toEmpresa(companyInfo);

        empresaRepository.save(empresa);
        return empresaMapper.toEmpresaInfoDto((empresa));
    }
}
