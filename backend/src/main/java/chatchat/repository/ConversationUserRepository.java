package chatchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chatchat.entity.ConversationUser;

public interface ConversationUserRepository extends JpaRepository<ConversationUser, Integer>{

}
