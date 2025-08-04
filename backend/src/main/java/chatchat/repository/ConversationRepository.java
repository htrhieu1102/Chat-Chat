package chatchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import chatchat.entity.Conversation;
import chatchat.entity.User;

public interface ConversationRepository extends JpaRepository<Conversation, Integer> {
    Conversation getConversationById(int id);

    @Query("""
            SELECT c FROM Conversation c
            JOIN c.conversationUsers cu1
            JOIN c.conversationUsers cu2
            WHERE c.isGroup = false
            AND cu1.user = :user1
            AND cu2.user = :user2
            """)
    Conversation findPrivateConversationBetween(@Param("user1") User user1,
            @Param("user2") User user2);
}
