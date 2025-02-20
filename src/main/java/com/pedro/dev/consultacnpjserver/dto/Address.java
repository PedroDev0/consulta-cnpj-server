package com.pedro.dev.consultacnpjserver.dto;

public record Address(
        int municipality,
        String street,
        String number,
        String details,
        String district,
        String city,
        String state,
        String zip,
        Country country
) {}
