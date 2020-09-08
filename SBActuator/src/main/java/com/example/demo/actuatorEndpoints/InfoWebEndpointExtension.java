package com.example.demo.actuatorEndpoints;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
@EndpointWebExtension(endpoint = InfoEndpoint.class)
@RequiredArgsConstructor
public class InfoWebEndpointExtension {

    private final InfoEndpoint delegate;

    @ReadOperation
    public WebEndpointResponse<Map> info() {
        Map<String, Object> infoMap = new LinkedHashMap<>();

        infoMap.put("This", "is");
        infoMap.put("extended", "info");
        infoMap.put("endpoint,", "dude!");

        Map<String, Object> info = this.delegate.info();
        infoMap.putAll(info);

        Integer status = getStatus(info);
        return new WebEndpointResponse<>(infoMap, status);
    }

    private Integer getStatus(Map<String, Object> info) {
        // return 5xx if this is a snapshot
        return 200;
    }
}