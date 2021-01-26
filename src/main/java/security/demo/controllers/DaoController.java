package security.demo.controllers;

import security.demo.entities.Score;
import security.demo.entities.User;
import security.demo.exception_handling.ResourceNotFoundException;
import security.demo.services.ScoreService;
import security.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class DaoController {
    private final UserService userService;
    private final ScoreService scoreService;


    @GetMapping("/score/inc")
    public String incScore(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to find user"));
        Score score = user.getScore();
        scoreService.save(score, 5);
        return "auth: " + user.getUsername() + " : " + user.getEmail() + "score increased to: " + user.getScore().getScore();
    }

    @GetMapping("/score/dec")
    public String decScore(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to find user"));
        Score score = user.getScore();
        scoreService.save(score, -5);
        return "auth: " + user.getUsername() + " : " + user.getEmail() + " score decreased to: " + user.getScore().getScore();
    }

    @GetMapping("/score/current")
    public String currentScore(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to find user"));
        return "auth: " + user.getUsername() + " : " + user.getEmail() + " score is: " + user.getScore().getScore();
    }

    @GetMapping("/score/{id}")
    public String getUserById(@PathVariable Long id) {
        User user = userService.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " doesn't exist"));
        return user.getUsername() + " : " + user.getEmail() + " score is: " + user.getScore().getScore();
    }
}
