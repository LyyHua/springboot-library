package com.deeznut.spring_boot_library.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/token")
public class TokenController {
    @GetMapping
    public ResponseEntity<JsonNode> getUserInfo(@RequestHeader(value = "Authorization") String token) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dev-8ee2kfetstsvkkz3.us.auth0.com/userinfo"))
                .header("Authorization", token)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.body());

        return ResponseEntity.ok(jsonNode);
    }
}
