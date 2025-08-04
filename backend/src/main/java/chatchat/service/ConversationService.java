package chatchat.service;

import java.util.List;

import chatchat.entity.Conversation;
import chatchat.entity.User;

public interface ConversationService {
    Conversation getConversationById(int id);
    Conversation saveConversation(List<Integer> userIds);

}
