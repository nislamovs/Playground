package com.example.slackConsumer.services;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface SlackApi {

    @POST()
    Call<Void> sendMessage(@Url String url, @Body Payload payload);
}
