package com.pedro.dev.consultacnpjserver.dto;

import java.util.List;

public record Company(
        long id,
        String name,
        long equity,
        Nature nature,
        Size size,
        List<Member> members
) {
}