package com.example.stats.jmx;


import com.example.stats.services.ConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.jmx.export.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;

@Component
@ManagedResource(description = "Application config bean")
@RequiredArgsConstructor
public class ConfigMBean {

    private final ConfigService configService;

    @ManagedAttribute(description = "Set reload attribute")
    public void setReloadPeriod(long newPeriodValue) {
        configService.setReloadPeriod(newPeriodValue);
    }

    @ManagedAttribute(description = "Get reload attribute")
    public long getReloadPeriod() {
        return configService.getReloadPeriod();
    }

    @ManagedOperation(description = "Get all config keys")
    public Collection<String> getConfigKeys() {
        return configService.configKeys();
    }

    @ManagedOperation(description = "Get value by key")
    @ManagedOperationParameters({
            @ManagedOperationParameter(name = "key", description = "Get a config value")
    })
    public String getConfig(String key) {
        return configService.getConfig(key);
    }

    @ManagedOperation(description = "Set value for particular key")
    @ManagedOperationParameters({
            @ManagedOperationParameter(name = "key", description = "Set a config value"),
            @ManagedOperationParameter(name = "value", description = "Set a config value")
    })
    public void setConfig(String key, String value) {
         configService.setConfig(key, value);
    }
}
