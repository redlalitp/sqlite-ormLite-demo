package com.lalitpatil.ormLiteDemo.controller;

import com.lalitpatil.ormLiteDemo.model.Team;
import com.lalitpatil.ormLiteDemo.model.User;
import com.lalitpatil.ormLiteDemo.service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value="/user")
    public ResponseEntity addBeer(@NonNull @RequestBody User user)
    {
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value="/users")
    public List<User> getAllBeers() throws IOException {
        return userService.getAllUsers();
    }

    @GetMapping(value="/userTeams/{emailId}")
    public List<String[]> getAllTeamsForUser(@PathVariable String emailId) throws SQLException {
        return userService.getAllTeamsForUSer(emailId);
    }
}
