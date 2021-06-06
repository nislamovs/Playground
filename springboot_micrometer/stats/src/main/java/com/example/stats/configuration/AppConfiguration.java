package com.example.stats.configuration;


import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@EnableAspectJAutoProxy
public class AppConfiguration {

    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }


    //Add this in case You want to place @Timed over restController endpoints

//    @Bean
//    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
//        return registry -> registry.config()
//                .commonTags("application", "yoyoy app")
//                .commonTags("class", "yoyoy app")
//                .commonTags("exception", "yoyoy app")
//                .commonTags("method", "yoyoy app")
//                .commonTags("outcome", "yoyoy app")
//                .commonTags("status", "yoyoy app")
//                .commonTags("uri", "yoyoy app")
//    }

}
