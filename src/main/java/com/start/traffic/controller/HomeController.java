package com.start.traffic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Slf4j
public class HomeController {
    @GetMapping("home")
    public String home() {
        log.info("connected");
        return "hello";
    }
}
