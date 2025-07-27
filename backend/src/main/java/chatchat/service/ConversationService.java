package chatchat.service;

import chatchat.entity.Conversation;

public interface ConversationService {
    Conversation getConversationById(int id);
    void createConversation(Conversation conversation);

}
