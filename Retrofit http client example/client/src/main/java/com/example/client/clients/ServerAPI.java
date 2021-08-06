package com.example.client.clients;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServerAPI {

  @GET("test1/")
  Call<String> runCall1();

  @GET("test2/")
  Call<String> runCall2();

}
