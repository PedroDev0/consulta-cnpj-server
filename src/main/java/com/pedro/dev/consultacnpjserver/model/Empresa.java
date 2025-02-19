package com.pedro.dev.consultacnpjserver.model;

import java.util.List;
import java.util.Set;

public class Empresa {

    private long empresaId;
    private  String cnpj;
    private String nomeRazaoSocial;
    private Set<Pessoa> membros;
}
