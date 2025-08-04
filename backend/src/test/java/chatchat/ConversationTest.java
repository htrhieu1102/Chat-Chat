package chatchat;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import chatchat.entity.Conversation;
import chatchat.repository.ConversationRepository;
import chatchat.service.ConversationService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ConversationTest {

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private ConversationService conversationService;

    @Test
    @Order(0)
    public void test() {
        // Conversation conversation = conversationService.getConversationById(0);
        // assertNotNull(conversation);
        System.out.println("TEst");
    }


}
