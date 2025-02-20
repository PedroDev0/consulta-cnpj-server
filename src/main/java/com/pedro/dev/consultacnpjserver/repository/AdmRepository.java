package com.pedro.dev.consultacnpjserver.repository;

import com.pedro.dev.consultacnpjserver.model.Adm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmRepository extends JpaRepository<Adm, String> {
    Adm findByKeyId(String keyId);
}