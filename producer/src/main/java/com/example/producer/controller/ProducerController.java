package com.example.producer.controller;

import com.example.producer.service.ProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProducerController {

    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping
    public String sendMessage(@RequestParam String topicName, @RequestParam String message){
        producerService.sendMessage(topicName, message);
        return "message: " + message + ". sent in topic " + topicName;
    }
}
