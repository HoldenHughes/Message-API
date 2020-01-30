package com.MessageAPI.MessageAPI;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    Message findOneById(Long id);
}
