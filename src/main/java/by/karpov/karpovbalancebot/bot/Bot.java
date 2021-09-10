package by.karpov.karpovbalancebot.bot;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class Bot extends TelegramLongPollingBot
{
	@Value("${bot.name}")
	private String botUserName;

	@Value("${bot.token}")
	private String botToken;

	@SneakyThrows
	@Override
	public void onUpdateReceived(Update update)
	{
		execute(SendMessage.builder().chatId(update.getMessage().getChatId().toString()).text("Hello world").build());
	}

	@Override
	public String getBotUsername()
	{
		return botUserName;
	}

	@Override
	public String getBotToken()
	{
		return botToken;
	}
}
