package com.pedro.dev.consultacnpjserver.model;

import jakarta.persistence.*;

@Entity(name = "ADM")
@Table(name = "ADM")
public class Adm {

    private String keyId;
    private String valueData;

    public Adm() {
    }

    @Id
    @Column(name = "KEY_ID")
    public String getKeyId() {
        return keyId;
    }

    @Column(name = "VALUE_DATA", nullable = false)
    public String getValueData() {
        return valueData;
    }

    public void setKeyId(String key) {
        this.keyId = keyId;
    }

    public void setValueData(String valueData) {
        this.valueData = valueData;
    }


}
