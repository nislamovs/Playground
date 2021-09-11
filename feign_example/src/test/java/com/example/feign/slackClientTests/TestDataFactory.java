package com.example.feign.slackClientTests;


import com.example.feign.domain.dto.SlackPayload;

public class TestDataFactory {

  public static SlackPayload prepareSlackPayload() {
    return SlackPayload.builder().text("testMessage").build();
  }
}
