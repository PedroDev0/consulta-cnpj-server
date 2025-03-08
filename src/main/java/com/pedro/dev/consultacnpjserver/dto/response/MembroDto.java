package com.pedro.dev.consultacnpjserver.dto.response;

import com.pedro.dev.consultacnpjserver.model.Pessoa;

public record MembroDto(String nome, String cpf, String cargo) {
    public MembroDto(Pessoa membro) {
        this(membro.getNome(),
                membro.getCpf(),
                membro.getCargo());
    }

}
