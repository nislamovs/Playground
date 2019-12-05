package com.example.slack;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SlackService {

    @Autowired
    OkHttpClient slackCall;

    @Autowired
    Request slackRequest;

    @SneakyThrows
    public String pushMessage(String msg) {

        RequestBody reqBody = RequestBody.create(msg.getBytes());
        Request req = slackRequest.newBuilder().post(reqBody).build();
        System.out.println(">>>  "+req.toString());
        slackCall.newCall(req).execute();

        return "Done!";
    }
}
