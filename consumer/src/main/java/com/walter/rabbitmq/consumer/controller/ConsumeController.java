package com.walter.rabbitmq.consumer.controller;

import com.walter.rabbitmq.consumer.controller.vo.ResultV1;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listener")
public class ConsumeController {
    private final SimpleMessageListenerContainer simpleMessageListenerContainer;

    public ConsumeController(SimpleMessageListenerContainer simpleMessageListenerContainer) {
        this.simpleMessageListenerContainer = simpleMessageListenerContainer;
    }

    @PutMapping("/stop")
    public ResultV1 stop() {
        final boolean isActive = simpleMessageListenerContainer.isActive();
        if (!isActive) {
            return ResultV1.of(false);
        }
        return listeningSwitch();
    }

    @PutMapping("/start")
    public ResultV1 start() {
        final boolean isActive = simpleMessageListenerContainer.isActive();
        if (isActive) {
            return ResultV1.of(true);
        }
        return listeningSwitch();
    }

    private ResultV1 listeningSwitch() {
        try {
            if (simpleMessageListenerContainer.isActive()) {
                simpleMessageListenerContainer.stop();
            } else {
                simpleMessageListenerContainer.start();
            }
            return ResultV1.of(simpleMessageListenerContainer.isActive());
        } catch (Exception e) {
            return ResultV1.of(simpleMessageListenerContainer.isActive(), e.getMessage());
        }
    }
}
