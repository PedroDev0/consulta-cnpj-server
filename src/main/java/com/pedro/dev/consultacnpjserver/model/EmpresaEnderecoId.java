package com.pedro.dev.consultacnpjserver.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class EmpresaEnderecoId implements Serializable {

    @Column(name = "empresa_id")
    private Long empresaId;

    @Column(name = "id")
    private Long id;

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}