package com.pedro.dev.consultacnpjserver.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "cpf", unique = true, nullable = false, length = 14)
    private String cpf;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "cargo", length = 100)
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    private  Empresa empresa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}

