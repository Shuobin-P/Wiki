package com.google.wiki.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @Value("${server.port:TEST}")
    String serverPort;

    @RequestMapping("/test")
    String test() {
        return "FFFFFFFFFFFFFFFFFF" + serverPort + "SSSSSS";
    }
}
