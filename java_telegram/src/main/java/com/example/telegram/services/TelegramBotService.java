package com.example.telegram.services;


import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TelegramBotService {

  @Value("${telegram.chatId}")
  private Integer chatId;
  private final TelegramBot telegramBot;

  public void sendMessage(String msg) {

    SendResponse response = telegramBot.execute(new SendMessage(chatId, msg));
		System.out.println(">>  "+response.toString());
  }

}
