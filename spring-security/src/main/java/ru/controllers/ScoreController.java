package ru.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.entities.User;
import ru.exception_handling.UserNotFoundException;
import ru.services.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/score")
@RequiredArgsConstructor
public class ScoreController {

    private final UserService userService;

    @GetMapping("/inc")
    public String incUserScore(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        userService.incUserScore(user);
        return "Score INC: [UserName: " + user.getUsername() + "; Score: " + user.getScores().getScore() + "]";
    }

    @GetMapping("/dec")
    public String decUserScore(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        userService.decUserScore(user);
        return "Score DEC: [UserName: " + user.getUsername() + "; Score: " + user.getScores().getScore() + "]";
    }

    @GetMapping("/get/current")
    public String getUserScore(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        return "CURRENT score: [UserName: " + user.getUsername() + "; Score: " + user.getScores().getScore() + "]";
    }

    @GetMapping("/get/{id}")
    public String getUserScoreById(@PathVariable Long id) {
        User user = userService.findById(id).orElseThrow(() ->
                new UserNotFoundException("User by ID = " + id + " not found")
        );
        return "User score by ID = " + id + ": [UserName: " + user.getUsername() + "; Score: " + user.getScores().getScore() + "]";
    }


}
