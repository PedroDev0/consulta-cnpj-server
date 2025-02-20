package com.pedro.dev.consultacnpjserver.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "EMPRESA")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "cnpj", unique = true, nullable = false, length = 18)
    private String cnpj;

    @Column(name = "nome_razao_social", nullable = false, length = 255)
    private String nomeRazaoSocial;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Pessoa> membros;

    @OneToOne(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EmpresaEndereco empresaEndereco;

    public long getId() {
        return id;
    }

    public void setId(long id) {  // Correção aqui
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeRazaoSocial() {
        return nomeRazaoSocial;
    }

    public void setNomeRazaoSocial(String nomeRazaoSocial) {
        this.nomeRazaoSocial = nomeRazaoSocial;
    }

    public Set<Pessoa> getMembros() {
        return membros;
    }

    public void setMembros(Set<Pessoa> membros) {
        this.membros = membros;
    }

    public EmpresaEndereco getEmpresaEndereco() {
        return empresaEndereco;
    }

    public void setEmpresaEndereco(EmpresaEndereco empresaEndereco) {
        this.empresaEndereco = empresaEndereco;
    }
}
