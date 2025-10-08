package com.dronacoderhub.client.controller;

import com.dronacoderhub.client.entity.User;
import com.dronacoderhub.client.event.RegistrationCompleteEvent;
import com.dronacoderhub.client.model.UserModel;
import com.dronacoderhub.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel) {
        User user = userService.registerUser(userModel);
        publisher.publishEvent(
                new RegistrationCompleteEvent(user,
                        "http://localhost:8080/confirm"));
        return "User registered successfully";
    }
}
