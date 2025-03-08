package com.pedro.dev.consultacnpjserver.dto.request;

public record Email(
        String ownership,
        String address,
        String domain
) {}