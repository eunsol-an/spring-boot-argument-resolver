package com.example.argumentresolver.controller;

import com.example.argumentresolver.anotation.User;
import com.example.argumentresolver.dto.UserDTO;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @GetMapping("/user")
    public ResponseEntity<UserDTO> testRestTemplate(@User UserDTO userDTO) {
        Gson gson = new Gson();
        log.info(gson.toJson(userDTO));
        return ResponseEntity.ok(userDTO);
    }
}
