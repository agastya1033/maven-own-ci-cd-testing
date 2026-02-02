package com.example;

import java.util.Random;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

    private int number = new Random().nextInt(10) + 1;

    @GetMapping("/guess/{input}")
    public String guess(@PathVariable int input) {
        if (input == number) {
            number = new Random().nextInt(10) + 1;
            return "🎉 Correct! New number generated.";
        } else if (input > number) {
            return "📉 Too high!";
        } else {
            return "📈 Too low!";
        }
    }

    @GetMapping("/health")
    public String health() {
        return "App is healthy 🚀";
    }
}
