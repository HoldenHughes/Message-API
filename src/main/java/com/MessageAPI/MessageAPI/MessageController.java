package com.MessageAPI.MessageAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
public class MessageController {

    @Autowired
    public MessageRepository messageRepository;

    @RequestMapping(path = "/message", method = RequestMethod.POST)
    public ResponseEntity<HashMap> wordCount(@Valid @RequestBody Message message) {
        if (messageRepository.findOneById(message.getId()) != null) {
            // do nothing
            return null;
            // return ResponseEntity.badRequest().body("ID already exists");
        } else {
            // save message to db
            messageRepository.save(message);

            // Create a hashmap for JSON Response
            HashMap<String, Long> responseMap = new HashMap<>();
            responseMap.put("count", 0l);

            // get all messages
            List<Message> messages = messageRepository.findAll();

            // Add current word count and total word count
            messages.forEach(m -> {
                responseMap.put("count", responseMap.get("count") + m.getWordCount());
            });

            // Return hashmap in the response -> {"count":"XXX"}
            return ResponseEntity.ok().body(responseMap);
        }
    }
}
