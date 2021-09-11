package com.example.feign.slackClientTests;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.HttpStatus;

public class SlackClientResponseMocks {

  public static void slackResponseMock_OK(WireMockServer mockService) {
    mockService.stubFor(WireMock.post(WireMock.urlEqualTo("/"))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.OK.value())));
  }

  public static void slackResponseMock_WrongApiKey(WireMockServer mockService) {
    mockService.stubFor(WireMock.post(WireMock.urlEqualTo("/"))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.FORBIDDEN.value())));
  }

  public static void slackResponseMock_Unauthorised(WireMockServer mockService) {
    mockService.stubFor(WireMock.post(WireMock.urlEqualTo("/"))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.UNAUTHORIZED.value())));
  }

  public static void slackResponseMock_4XX(WireMockServer mockService) {
    mockService.stubFor(WireMock.post(WireMock.urlEqualTo("/"))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.BAD_REQUEST.value())));
  }

  public static void slackResponseMock_5XX(WireMockServer mockService) {
    mockService.stubFor(WireMock.post(WireMock.urlEqualTo("/"))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.SERVICE_UNAVAILABLE.value())));
  }

  public static void slackResponseMock_UnknownResponseCode(WireMockServer mockService) {
    mockService.stubFor(WireMock.post(WireMock.urlEqualTo("/"))
        .willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.NOT_MODIFIED.value())));
  }
}
