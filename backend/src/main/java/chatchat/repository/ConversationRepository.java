package chatchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chatchat.entity.Conversation;

public interface ConversationRepository extends JpaRepository<Conversation, Integer>{
    Conversation getConversationById(int id);
}
