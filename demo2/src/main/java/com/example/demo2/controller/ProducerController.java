package com.example.demo2.controller;

import com.example.demo2.dto.MyMessage;
import com.example.demo2.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerService producerService;

    @RequestMapping("/publish")
    public String publish(String message) {
        producerService.send(message);

        return "publish a message : " + message;
    }

    @RequestMapping("/publish2")
    public String publishWithCallback(String message) {
        producerService.sendWithCallback(message);

        return "publish a message with callback : " + message;
    }

    @RequestMapping("/publish3")
    public String publishJson(MyMessage myMessage) {
        producerService.sendJson(myMessage);

        return "publish a message with callback : " + myMessage.getName() + ", " + myMessage.getMessage();
    }

}
