package chatchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chatchat.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

}
