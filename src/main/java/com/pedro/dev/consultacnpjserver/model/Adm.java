package com.pedro.dev.consultacnpjserver.model;

import jakarta.persistence.*;

@Entity(name = "ADM")
@Table(name = "ADM")
public class Adm {

    private String key;
    private String value;

    public Adm() {

    }

    @Id
    @Column(name = "ID")
    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
