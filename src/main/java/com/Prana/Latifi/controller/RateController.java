package com.Prana.Latifi.controller;

import com.Prana.Latifi.helper.ResponseHelper;
import com.Prana.Latifi.jwt.JwtFactory;
import com.Prana.Latifi.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rate")
public class RateController {

    @Autowired
    private RateService rateService;

    @PostMapping(value = "/rate-item")
    public ResponseEntity rateItem(@RequestParam long itemId, @RequestParam int rate, @RequestParam String token){
        return ResponseHelper.response(
                rateService.rateItem(
                        itemId, rate, token
                )
        );
    }

    @GetMapping(value = "/current-rate")
    public ResponseEntity rateItem(@RequestParam long itemId, @RequestParam String token){
        return ResponseHelper.response(
                rateService.getCurrentRate(
                        itemId, token
                )
        );
    }

}

