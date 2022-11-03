package com.example.restaurant.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SupportController {

    @GetMapping("/status")
    ResponseEntity getStatus() {
        Map response = new HashMap<String, String>() {{
           put("status", "Online");
           put("timestamp", new Date().toString());
        }};
        return ResponseEntity.ok(response);
    }
}
