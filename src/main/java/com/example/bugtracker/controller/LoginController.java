package com.example.bugtracker.controller;

import com.example.bugtracker.dto.LoginRequest;
import com.example.bugtracker.dto.LoginResponse;
import com.example.bugtracker.model.*;
import com.example.bugtracker.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*") // For simplicity during development
public class LoginController {

    @Autowired private TesterRepository testerRepo;
    @Autowired private DeveloperRepository devRepo;
    @Autowired private ProjectManagerRepository pmRepo;

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        String role = request.getRole();
        
        LoginResponse response = new LoginResponse();
        
        switch (role.toLowerCase()) {
            case "tester":
                Tester tester = testerRepo.findByUsername(username);
                if (tester != null && tester.getPassword().equals(password)) {
                    response.setId(tester.getId());
                    response.setUsername(tester.getUsername());
                    response.setRole("tester");
                    response.setSuccess(true);
                    return ResponseEntity.ok(response);
                }
                break;
            case "developer":
                Developer dev = devRepo.findByUsername(username);
                if (dev != null && dev.getPassword().equals(password)) {
                    response.setId(dev.getId());
                    response.setUsername(dev.getUsername());
                    response.setRole("developer");
                    response.setSuccess(true);
                    return ResponseEntity.ok(response);
                }
                break;
            case "pm":
                ProjectManager pm = pmRepo.findByUsername(username);
                if (pm != null && pm.getPassword().equals(password)) {
                    response.setId(pm.getId());
                    response.setUsername(pm.getUsername());
                    response.setRole("pm");
                    response.setSuccess(true);
                    return ResponseEntity.ok(response);
                }
                break;
        }

        response.setSuccess(false);
        response.setMessage("Invalid username or password");
        return ResponseEntity.ok(response);
    }
}