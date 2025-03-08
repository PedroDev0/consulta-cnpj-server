package com.pedro.dev.consultacnpjserver.dto.request;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

public record CompanyInfo(
        ZonedDateTime updated,
        String taxId,
        Company company,
        String alias,
        LocalDate founded,
        boolean head,
        LocalDate statusDate,
        Status status,
        Address address,
        List<Phone> phones,
        List<Email> emails,
        Activity mainActivity,
        List<Activity> sideActivities
) {}