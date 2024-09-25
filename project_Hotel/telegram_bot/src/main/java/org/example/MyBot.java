package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MyBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();

        Long chatId = message.getChatId();

        System.out.println(message.getText());
    }

    @Override
    public String getBotUsername() {
        return "g47_test_bot";
    }

    @Override
    public String getBotToken() {
        return "7523515725:AAED3Rw4JA-FA7CBDsa4TiGZ3cTHLIVjv9g";
    }
}
