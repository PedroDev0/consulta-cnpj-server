package com.pedro.dev.consultacnpjserver.mappper;

import com.pedro.dev.consultacnpjserver.dto.request.CompanyInfo;
import com.pedro.dev.consultacnpjserver.dto.response.EmpresaEnderecoDto;
import com.pedro.dev.consultacnpjserver.dto.response.EmpresaInfoDto;
import com.pedro.dev.consultacnpjserver.dto.response.MembroDto;
import com.pedro.dev.consultacnpjserver.model.Empresa;
import com.pedro.dev.consultacnpjserver.model.EmpresaEndereco;
import com.pedro.dev.consultacnpjserver.model.Pessoa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmpresaMapper {

    public Empresa toEmpresa(CompanyInfo companyInfo) {

        Empresa empresa = new Empresa();
        empresa.setCnpj(companyInfo.taxId());
        empresa.setNomeRazaoSocial(companyInfo.company().name());

        // endreco
        EmpresaEndereco empresaEndereco = new EmpresaEndereco();

        empresaEndereco.setCidade(companyInfo.address().city());
        empresaEndereco.setCep(companyInfo.address().zip());
        empresaEndereco.setUf(companyInfo.address().state());
        empresaEndereco.setNumero(companyInfo.address().number());
        empresaEndereco.setEndereco(companyInfo.address().district() + " " + companyInfo.address().street());
        empresaEndereco.setComplemento(companyInfo.address().details());
        empresaEndereco.setEmpresa(empresa);
        empresa.setEndereco(empresaEndereco);

        // Membros
        Set<Pessoa> pessoas = new HashSet<>();
        companyInfo.company().members().forEach(e -> {
                    Pessoa pessoa = new Pessoa();
                    pessoa.setNome(e.person().name());
                    pessoa.setCargo(e.role().text());
                    pessoa.setCpf(e.person().taxId());
                    pessoa.setEmpresa(empresa);
                    pessoas.add(pessoa);

                }
        );
        empresa.setMembros(pessoas);
        return empresa;
    }

    public EmpresaInfoDto toEmpresaInfoDto(Empresa empresa){

        List<MembroDto> membros =  empresa.getMembros().stream().map(MembroDto::new).toList();
        EmpresaEnderecoDto empresaEnderecoDto =  new EmpresaEnderecoDto(empresa.getEndereco());

        return new EmpresaInfoDto(empresa,empresaEnderecoDto,membros );

    }
}
