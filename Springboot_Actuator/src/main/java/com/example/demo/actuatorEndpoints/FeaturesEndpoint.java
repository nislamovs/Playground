package com.example.demo.actuatorEndpoints;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features", enableByDefault = true)
public class FeaturesEndpoint {

    private static Map<String, Feature> features = new ConcurrentHashMap<>();

    static {
        features.put("superFeature 1", new Feature(true));
        features.put("superFeature 2", new Feature(false));
    }

    @ReadOperation
    public Map<String, Feature> features() {
        return features;
    }

    @ReadOperation
    public Feature feature(@Selector String name) {
        return features.get(name);
    }

    @WriteOperation
    public void configureFeature(@Selector String name, Feature feature) {
        features.put(name, feature);
    }

    @DeleteOperation
    public void deleteFeature(@Selector String name) {
        features.remove(name);
    }

    @Getter @Setter
    @AllArgsConstructor
    public static class Feature {

        private Boolean enabled;
    }

}