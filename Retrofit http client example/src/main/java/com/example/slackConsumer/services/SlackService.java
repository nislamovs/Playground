package com.example.slackConsumer.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;

@Slf4j
@Service
@RequiredArgsConstructor
public class SlackService {

    @Value("${slack.token}")
    private String slackPath;

    private final Retrofit retrofit;
    private SlackApi slackApi;

    @PostConstruct
    public void fooInit(){
      this.slackApi =  retrofit.create(SlackApi.class);
    }

    @SneakyThrows
    public boolean test() {
      return slackApi.sendMessage(slackPath, new Payload("asdasdasdasd")).execute().isSuccessful();
    }
}
