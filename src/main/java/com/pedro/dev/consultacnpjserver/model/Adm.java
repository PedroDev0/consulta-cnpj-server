package com.pedro.dev.consultacnpjserver.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ADM")
public class Adm {

    @Id
    @Column(name = "KEY_ID", length = 100) // Definindo tamanho do VARCHAR para corresponder ao schema
    private String keyId;

    @Column(name = "VALUE_DATA", nullable = false, length = 255) // Evita valores nulos e define o tamanho
    private String valueData;

    public Adm() {
    }


    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getValueData() {
        return valueData;
    }

    public void setValueData(String valueData) {
        this.valueData = valueData;
    }
}
