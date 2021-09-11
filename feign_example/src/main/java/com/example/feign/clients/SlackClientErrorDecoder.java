package com.example.feign.clients;

import com.example.feign.domain.exceptions.SlackTokenAuthException;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SlackClientErrorDecoder implements ErrorDecoder {

  private final ErrorDecoder defaultErrorDecoder = new Default();

  @Override
  public Exception decode(String methodKey, Response response) {

    Exception exception = defaultErrorDecoder.decode(methodKey, response);
    if (exception instanceof RetryableException) {
      return exception;
    }

    if (response.status() == HttpStatus.UNAUTHORIZED.value()
        || response.status() == HttpStatus.FORBIDDEN.value()) {
      return new SlackTokenAuthException("apiKey is invalid");
    }

    if (HttpStatus.valueOf(response.status()).is4xxClientError()) {
        return new RetryableException(response.status(), methodKey, null,
            new Date(System.currentTimeMillis() + 1000),
            response.request());
    }

    if (HttpStatus.valueOf(response.status()).is5xxServerError()) {
        return new RetryableException(response.status(), methodKey, null,
            new Date(System.currentTimeMillis() + 1000),
            response.request());
    }

    return new Exception(response.reason());
  }
}