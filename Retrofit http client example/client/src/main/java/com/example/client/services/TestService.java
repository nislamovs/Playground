package com.example.client.services;


import com.example.client.clients.ServerAPI;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService implements Callback {

//  private final ServerAPI serverAPI;
  private final Retrofit retrofit;

  @SneakyThrows
  public String testCall1() {
    ServerAPI serverAPI = retrofit.create(ServerAPI.class);
    Call<String> call = serverAPI.runCall1();

    call.enqueue(this);
    return "ok";
  }

  @SneakyThrows
  public String testCall2() {
    ServerAPI serverAPI = retrofit.create(ServerAPI.class);
    Call<String> call = serverAPI.runCall2();

    call.enqueue(this);
    return "ok";
  }

  @Override
  public void onResponse(Call call, Response response) {
    if(response.isSuccessful()) {
      System.out.println(response.body());
    } else {
      System.out.println(response.errorBody());
    }
  }

  @Override
  public void onFailure(Call call, Throwable t) {
    t.printStackTrace();
  }

}
