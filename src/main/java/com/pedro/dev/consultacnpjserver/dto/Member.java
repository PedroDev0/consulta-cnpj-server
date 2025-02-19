package com.pedro.dev.consultacnpjserver.dto;

public record Member(
        String since,
        Role role,
        Person person
) {}