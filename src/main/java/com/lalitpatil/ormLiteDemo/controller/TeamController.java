package com.lalitpatil.ormLiteDemo.controller;

import com.lalitpatil.ormLiteDemo.model.Team;
import com.lalitpatil.ormLiteDemo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping(value = "/teams")
    public List<Team> getAllTeams() throws IOException {
        return teamService.getAllTeams();
    }
}
