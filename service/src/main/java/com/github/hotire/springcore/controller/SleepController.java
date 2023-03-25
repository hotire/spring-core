package com.github.hotire.springcore.controller;

import java.security.SecureRandom;
import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sleep")
public class SleepController {

    final Random random = new SecureRandom();

    @GetMapping("/random")
    public String randomSleep(@RequestParam String result) throws InterruptedException {
        Thread.sleep(random.nextInt(1000));
        return result;
    }
}
