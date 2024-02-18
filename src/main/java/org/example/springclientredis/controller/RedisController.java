package org.example.springclientredis.controller;

import org.example.springclientredis.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/redis")
public class RedisController {

    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping
    public String getKey(@RequestParam String key) {
        return redisService.get(key);
    }

    @PostMapping
    public void setKey(@RequestParam String key, @RequestParam String value) {
        redisService.set(key, value);
    }

}
