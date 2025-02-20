package com.pedro.dev.consultacnpjserver.dto;

public record Email(
        String ownership,
        String address,
        String domain
) {}