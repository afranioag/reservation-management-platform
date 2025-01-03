package com.ead.notification.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/api", name = "CONTROLLER NOTIFICATION")
public class NotificationController {
    private static final Logger log = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value(value = "${reservation.api.url.authuser}")
    private String URL_AUTHOUSER;

    @GetMapping("/iam")
    public ResponseEntity<Object> getNotifications() {
        Notification notification = new Notification();
        notification.message = "Hello World. I am Notification Service";

        return ResponseEntity.ok(notification);
    }

    @GetMapping(value = "/authuser")
    public ResponseEntity<Object> getAuthuser() {
        ResponseEntity<Notification> responseEntity = restTemplate.exchange(URL_AUTHOUSER, HttpMethod.GET, HttpEntity.EMPTY, Notification.class);

        return new ResponseEntity<>(responseEntity.getBody(), HttpStatus.OK);
    }

    public static class Notification {
        public String message;
    }
}
