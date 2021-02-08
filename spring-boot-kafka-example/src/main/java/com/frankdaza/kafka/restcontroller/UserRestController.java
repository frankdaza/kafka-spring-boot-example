package com.frankdaza.kafka.restcontroller;

import com.frankdaza.kafka.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
@RequiredArgsConstructor
public class UserRestController {

//    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, User> kafkaTemplateModel;
    private final static String TOPIC = "Kafka_Example";

//    @GetMapping("/publish/{message}")
//    public String post(@PathVariable("message") final String message) {
//        kafkaTemplate.send(TOPIC, message);
//        return "Published Successfully!";
//    }

    @GetMapping("/publish/model/{name}")
    public String postModel(@PathVariable("name") final String name) {
        User user = new User(name, "Engineer", 10000.0);
        kafkaTemplateModel.send(TOPIC, user);
        return "Published Successfully!";
    }
}
