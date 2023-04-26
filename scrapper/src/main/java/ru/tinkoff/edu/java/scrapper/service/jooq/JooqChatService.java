package ru.tinkoff.edu.java.scrapper.service.jooq;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import ru.tinkoff.edu.java.scrapper.persistence.model.Chat;
import ru.tinkoff.edu.java.scrapper.persistence.repository.ChatRepository;
import ru.tinkoff.edu.java.scrapper.service.TgChatService;

@RequiredArgsConstructor
public class JooqChatService implements TgChatService {
    private final ChatRepository chatRepository;

    @Override
    public boolean register(long chatId) {
        try {
            chatRepository.addChatById(chatId);
            return true;
        } catch (DuplicateKeyException exc) {
            return false;
        }
    }

    @Override
    public void unregister(long chatId) {
        chatRepository.removeChatById(chatId);
    }

    @Override
    public boolean isChatExist(long chatId) {
        Chat chat = chatRepository.findChatById(chatId);
        return chat != null;
    }
}
