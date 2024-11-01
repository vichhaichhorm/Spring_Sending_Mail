package com.vichhaicoder.userservice_send_mail.controller;

import com.vichhaicoder.userservice_send_mail.modal.apiResponse.HttpResponse;
import com.vichhaicoder.userservice_send_mail.modal.entity.User;
import com.vichhaicoder.userservice_send_mail.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<HttpResponse> createUser(@RequestBody User user){
        User newUser = userService.saveUser(user);
        return ResponseEntity.created(URI.create("")).body(
                HttpResponse.builder()
                        .timeSpam(LocalDateTime.now().toString())
                        .payload(Map.of("user",newUser))
                        .message("User created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }
    @GetMapping("/get/{token}")
    public ResponseEntity<HttpResponse> confirmUserAccount(@PathVariable String token){
        Boolean isSuccess = userService.verifyToken(token);
        return ResponseEntity.created(URI.create("")).body(
                HttpResponse.builder()
                        .timeSpam(LocalDateTime.now().toString())
                        .payload(Map.of("Get use success",isSuccess))
                        .message("Account Verified.")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

}
