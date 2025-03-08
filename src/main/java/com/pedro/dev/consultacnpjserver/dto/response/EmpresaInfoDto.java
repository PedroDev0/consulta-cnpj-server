package com.pedro.dev.consultacnpjserver.dto.response;

import com.pedro.dev.consultacnpjserver.model.Empresa;

import java.util.List;

public record EmpresaInfoDto(String nome, String cnpj, EmpresaEnderecoDto endreco,
                             List<MembroDto> membros) {
    public EmpresaInfoDto(Empresa empresa , EmpresaEnderecoDto endreco,
                          List<MembroDto> membros){
        this(empresa.getNomeRazaoSocial(),
                empresa.getCnpj(),
                endreco,
                membros);
    }

}
