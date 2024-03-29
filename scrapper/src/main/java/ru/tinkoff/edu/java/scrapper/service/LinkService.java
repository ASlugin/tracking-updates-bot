package ru.tinkoff.edu.java.scrapper.service;

import java.net.URI;
import java.util.List;
import ru.tinkoff.edu.java.scrapper.persistence.model.Link;

public interface LinkService {
    Link add(long tgChatId, URI url);

    Link remove(long tgChatId, URI url);

    List<Link> listAll(long tgChatId);
}
