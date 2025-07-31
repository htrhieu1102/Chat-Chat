package chatchat.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import chatchat.entity.Conversation;
import chatchat.entity.ConversationUser;
import chatchat.entity.User;
import chatchat.repository.ConversationRepository;
import chatchat.repository.ConversationUserRepository;
import chatchat.repository.UserRepository;
import chatchat.service.ConversationService;

@Service
public class ConversationServiceImpl implements ConversationService {
    private ConversationRepository conversationRepository;
    private UserRepository userRepository;
    private ConversationUserRepository conversationUserRepository;

    @Autowired
    public ConversationServiceImpl(ConversationRepository conversationRepository, UserRepository userRepository,
            ConversationUserRepository conversationUserRepository) {
        this.conversationRepository = conversationRepository;
        this.userRepository = userRepository;
        this.conversationUserRepository = conversationUserRepository;
    }

    @Override
    public Conversation getConversationById(int id) {
        return conversationRepository.getConversationById(id);
    }

    @Override
    public void saveConversation(List<Integer> userIds) {
        Authentication authentication;
        try {
            authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication == null || !authentication.isAuthenticated()) {
                throw new AccessDeniedException("Authentication is null or not authenticated");
            }
        } catch (Exception e) {
            throw new AccessDeniedException("Failed to get authentication");
        }
        System.out.println(authentication.getName());
        User user = userRepository.findByUsername(authentication.getName());
        System.out.println(user);
        boolean isGroup = userIds.size() > 1;
        List<User> users = userRepository.findAllById(userIds);

        Conversation conversation = new Conversation();
        conversation.setGroup(isGroup);
        conversation.setCreateAt(LocalDateTime.now());

        Conversation saveConversation = conversationRepository.save(conversation);

        ConversationUser fistOne = new ConversationUser();
        fistOne.setUser(user);
        fistOne.setConversation(saveConversation);
        if (isGroup)
            fistOne.setRoleInConversation("ADMIN");
        conversationUserRepository.save(fistOne);
        for (int i = 0; i < users.size(); i++) {
            ConversationUser conversationUser = new ConversationUser();
            conversationUser.setUser(users.get(i));
            conversationUser.setConversation(saveConversation);
            conversationUserRepository.save(conversationUser);
            if (isGroup)
                fistOne.setRoleInConversation("MEMBER");
        }

    }

}
