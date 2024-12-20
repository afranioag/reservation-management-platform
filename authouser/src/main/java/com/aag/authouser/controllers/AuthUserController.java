package com.aag.authouser.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/authusers")
public class AuthUserController {
    private static final Logger log = LoggerFactory.getLogger(AuthUserController.class);

    @GetMapping
    public ResponseEntity<Object> getAuthUsers() {
        Notification notification = new Notification();
        notification.message = "Hello World. I am Authenticated User";

        return ResponseEntity.ok(notification);
    }

    @GetMapping(value = "/notification")
    public ResponseEntity<Object> getNotifications() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Notification> responseEntity = restTemplate.exchange("http://localhost:8092/notifications", HttpMethod.GET, HttpEntity.EMPTY, Notification.class);

        return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
    }

    public static class Notification {
        public String message;
    }
}
