package com.dronacoderhub.client.listener;

import com.dronacoderhub.client.entity.User;
import com.dronacoderhub.client.event.RegistrationCompleteEvent;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class RegistrationCompleteEventListener
        implements ApplicationListener<RegistrationCompleteEvent> {
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //create the verification token for the user
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        //Send mail to user
    }
}
