package com.example.feign.clients;

import com.example.feign.domain.dto.SlackPayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "slackClient1", url = "${slackclient.url:emptyAUrl}", configuration = FeignConfiguration.class)
public interface SlackClient {

    @PostMapping
    void pushSlackMsg(@RequestBody SlackPayload payload);
}