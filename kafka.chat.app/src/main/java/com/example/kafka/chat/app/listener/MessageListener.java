package com.example.kafka.chat.app.listener;

import com.example.kafka.chat.app.model.Message;
import com.example.kafka.chat.app.props.KafkaConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class MessageListener {

    @Autowired
    private SimpMessagingTemplate template;

    @KafkaListener(
            topics = KafkaConstants.KAFKA_TOPIC,
            groupId = KafkaConstants.GROUP_ID
    )
    public void listen(Message message) {
        System.out.println("sending via kafka listener ...");
        template.convertAndSend("/topic/group" + message);
    }
}
