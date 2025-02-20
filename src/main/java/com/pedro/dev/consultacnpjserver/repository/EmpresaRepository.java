package com.pedro.dev.consultacnpjserver.repository;

import com.pedro.dev.consultacnpjserver.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa,Long> {

    Empresa findByCnpj(String cnpj);
}
