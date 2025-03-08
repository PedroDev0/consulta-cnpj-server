package com.pedro.dev.consultacnpjserver.dto.request;

public record Phone(
        String type,
        String area,
        String number
) {}