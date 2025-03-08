package com.pedro.dev.consultacnpjserver.dto.response;

import com.pedro.dev.consultacnpjserver.model.EmpresaEndereco;

public record EmpresaEnderecoDto(String cidade, String complemento, String uf, String cep, String numero) {

    public EmpresaEnderecoDto(EmpresaEndereco endereco) {
        this(endereco.getCidade(),
                endereco.getComplemento(),
                endereco.getUf(),
                endereco.getCep(),
                endereco.getNumero()
        );
    }
}
