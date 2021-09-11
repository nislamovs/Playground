package com.example.telegram.configuration;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TelegramClientConfiguration {

  @Value("${telegram.token}")
  private String botToken;

  @Bean
  public TelegramBot telegramBot() {
    TelegramBot bot = new TelegramBot(botToken);
    bot.setUpdatesListener(updates -> {
			// ... process updates
			// return id of last processed update or confirm them all
			return UpdatesListener.CONFIRMED_UPDATES_ALL;
		});

    return bot;
  }

}
