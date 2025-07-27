package chatchat.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chatchat.entity.Conversation;
import chatchat.repository.ConversationRepository;
import chatchat.service.ConversationService;

@Service
public class ConversationServiceImpl implements ConversationService{
    private ConversationRepository conversationRepository;

    @Autowired
    public ConversationServiceImpl(ConversationRepository conversationRepository) {
        this.conversationRepository = conversationRepository;
    }

    @Override
    public Conversation getConversationById(int id) {
        return conversationRepository.getConversationById(id);
    }

    @Override
    public void createConversation(Conversation conversation) {
        conversation.setCreateAt(LocalDateTime.now());
        conversation.setUpdateAt(LocalDateTime.now());
        conversationRepository.save(conversation);
    }
    

}
