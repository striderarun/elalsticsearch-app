package com.arun.app.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SearchController {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}
