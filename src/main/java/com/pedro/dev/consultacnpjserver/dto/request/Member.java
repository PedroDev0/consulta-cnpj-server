package com.pedro.dev.consultacnpjserver.dto.request;

public record Member(
        String since,
        Role role,
        Person person
) {}