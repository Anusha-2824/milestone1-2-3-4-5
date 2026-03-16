package com.inventra.controller;

import com.inventra.dto.LoginRequest;
import com.inventra.model.User;
import com.inventra.service.AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // ================= LOGIN =================
    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody LoginRequest request) {

        Map<String,String> token = authService.login(
                request.getUsername(),
                request.getPassword()
        );

        return ResponseEntity.ok(token);
    }

    // ================= REGISTER =================
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String username,
                                           @RequestParam String email,
                                           @RequestParam String password,
                                           @RequestParam String role) {

        String response = authService.register(username,email,password,role);

        return ResponseEntity.ok(response);
    }

    // ================= GET PENDING USERS =================
    @GetMapping("/pending")
    public ResponseEntity<List<User>> getPendingUsers() {

        return ResponseEntity.ok(authService.getPendingUsers());
    }

    // ================= APPROVE USER =================
    @PutMapping("/approve/{id}")
    public ResponseEntity<String> approveUser(@PathVariable Long id) {

        return ResponseEntity.ok(authService.approveUser(id));
    }

    // ================= REJECT USER =================
    @DeleteMapping("/reject/{id}")
    public ResponseEntity<String> rejectUser(@PathVariable Long id) {

        return ResponseEntity.ok(authService.rejectUser(id));
    }

    // ================= LOCKED USERS =================
    @GetMapping("/locked")
    public ResponseEntity<List<User>> getLockedUsers() {

        return ResponseEntity.ok(authService.getLockedUsers());
    }

    // ================= UNLOCK USER =================
    @PutMapping("/unlock/{id}")
    public ResponseEntity<String> unlockUser(@PathVariable Long id) {

        return ResponseEntity.ok(authService.unlockUser(id));
    }
}