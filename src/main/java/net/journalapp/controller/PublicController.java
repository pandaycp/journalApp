package net.journalapp.controller;

import net.journalapp.entity.UserEntity;
import net.journalapp.model.User;
import net.journalapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    private final UserService userService;

    PublicController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/health-check")
    public String healthCheck(){
        return "ok";
    }

    @PostMapping("/create-user")
    public ResponseEntity<Integer> createUser(@RequestBody User user){
        userService.saveEntry(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
