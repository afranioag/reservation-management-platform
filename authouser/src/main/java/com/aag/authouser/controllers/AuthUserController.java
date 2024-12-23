package com.aag.authouser.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/api")
public class AuthUserController {
    private static final Logger log = LoggerFactory.getLogger(AuthUserController.class);

    @Autowired
    private RestTemplate restTemplate;

    private String URL_NOTIFICATION = " ";

    @GetMapping(value = "/iam")
    public ResponseEntity<Object> getAuthUsers() {
        Notification notification = new Notification();
        notification.message = "Hello World. I am Authenticated User";

        return ResponseEntity.ok(notification);
    }

    @GetMapping(value = "/notification")
    public ResponseEntity<Object> getNotifications() {
        log.info("Chamada externa. ");

        ResponseEntity<Notification> responseEntity = restTemplate.exchange(URL_NOTIFICATION, HttpMethod.GET, HttpEntity.EMPTY, Notification.class);

        return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
    }

    public static class Notification {
        public String message;
    }
}
