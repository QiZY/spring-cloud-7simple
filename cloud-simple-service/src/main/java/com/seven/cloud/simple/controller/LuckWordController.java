package com.seven.cloud.simple.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by QiZY on 2017-5-24.
 */
@RestController
public class LuckWordController {
    @Value("${lucky-word}")
    String luckyWord;

    @RequestMapping("/lucky-word")
    public String showLuckyWord() {
        return "The lucky word is: " + luckyWord;
    }
}
