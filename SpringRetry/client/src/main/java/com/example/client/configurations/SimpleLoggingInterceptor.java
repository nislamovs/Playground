package com.example.client.configurations;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Slf4j
public class SimpleLoggingInterceptor implements Interceptor {


  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();

    log.info("Intercepted headers: {} from URL: {}", request.headers(), request.url());

    return chain.proceed(request);
  }
}