package com.pedro.dev.consultacnpjserver.dto;

public record Person(
        String id,
        String name,
        String type,
        String taxId,
        String age
) {
}
