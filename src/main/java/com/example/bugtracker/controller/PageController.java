package com.example.bugtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index.html"; // this will serve index.html from /static
    }

    @GetMapping("/login")
    public String login() {
        return "index.html"; // custom endpoint for login page
    }

    @GetMapping("/tester")
    public String testerDashboard() {
        return "tester-dashboard.html";
    }

    @GetMapping("/pm")
    public String pmDashboard() {
        return "pm-dashboard.html";
    }

    @GetMapping("/dev")
    public String devDashboard() {
        return "developer-dashboard.html";
    }
}