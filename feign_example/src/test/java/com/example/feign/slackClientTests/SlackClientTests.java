package com.example.feign.slackClientTests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.feign.clients.SlackClient;
import com.example.feign.domain.exceptions.SlackTokenAuthException;
import com.github.tomakehurst.wiremock.WireMockServer;
import feign.RetryableException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WireMockConfig.class})
class SlackClientTests {

  @Autowired
  private WireMockServer mockSlackServer;
  @Autowired
  private SlackClient slackClients;

//  @Test
//  @Order(0)
//  void init() {
//    System.out.println(">>>>>   " + Arrays.toString(env.getActiveProfiles()));
//    System.out.println(">>>>>   " + env.getProperty("slack.url") );
//  }

  @Test
  void whenSendMessage_thenOk_andNothingHappens() {
    SlackClientResponseMocks.slackResponseMock_OK(mockSlackServer);
    assertDoesNotThrow(() -> {
      slackClients.pushSlackMsg(
          TestDataFactory.prepareSlackPayload());
    });
  }

  @Test
  void whenSendMessage_then401ResponseReceived_andslackServiceExceptionIsThrown() {
    SlackClientResponseMocks.slackResponseMock_Unauthorised(mockSlackServer);
    assertThrows(SlackTokenAuthException.class, () -> {
      slackClients.pushSlackMsg(
          TestDataFactory.prepareSlackPayload());
    });
  }

  @Test
  void whenSendMessage_then403ResponseReceived_andslackServiceExceptionIsThrown() {
    SlackClientResponseMocks.slackResponseMock_WrongApiKey(mockSlackServer);
    assertThrows(SlackTokenAuthException.class, () -> {
      slackClients.pushSlackMsg(
          TestDataFactory.prepareSlackPayload());
    });
  }

  @Test
  void whenSendMessage_then400ResponseReceived_andRetryableExceptionIsThrown() {
    SlackClientResponseMocks.slackResponseMock_4XX(mockSlackServer);
    assertThrows(RetryableException.class, () -> {
      slackClients.pushSlackMsg(
          TestDataFactory.prepareSlackPayload());
    });
  }

  @Test
  void whenSendMessage_then500ResponseReceived_andRetryableExceptionIsThrown() {
    SlackClientResponseMocks.slackResponseMock_5XX(mockSlackServer);
    assertThrows(RetryableException.class, () -> {
      slackClients.pushSlackMsg(
          TestDataFactory.prepareSlackPayload());
    });
  }

  @Test
  void whenSendMessage_thenUnknownResponseReceived_andExceptionIsThrown() {
    SlackClientResponseMocks.slackResponseMock_UnknownResponseCode(mockSlackServer);
    assertThrows(Exception.class, () -> {
      slackClients.pushSlackMsg(
          TestDataFactory.prepareSlackPayload());
    });
  }
}
