package com.pedro.dev.consultacnpjserver.repository;

import com.pedro.dev.consultacnpjserver.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
