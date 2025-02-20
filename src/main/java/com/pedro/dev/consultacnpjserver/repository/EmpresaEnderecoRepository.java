package com.pedro.dev.consultacnpjserver.repository;

import com.pedro.dev.consultacnpjserver.model.EmpresaEndereco;
import com.pedro.dev.consultacnpjserver.model.EmpresaEnderecoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaEnderecoRepository extends JpaRepository<EmpresaEndereco, EmpresaEnderecoId> {
}
