package com.pedro.dev.consultacnpjserver.config;

import com.pedro.dev.consultacnpjserver.model.Adm;
import com.pedro.dev.consultacnpjserver.repository.AdmRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConfigService {

    @Autowired
    private AdmRepository admRepository;

    private final Map<String, String> configCache = new HashMap<>();

    @PostConstruct
    private void loadConfig() {
        List<Adm> results = admRepository.findAll();
        for (Adm adm : results) {
            configCache.put(adm.getKeyId(), adm.getValueData());
        }
    }

    public String getConfig(String key) {
        return configCache.get(key);
    }
}