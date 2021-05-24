package com.Prana.Latifi.service;

import com.Prana.Latifi.response.RateResponse;

public interface RateService {

    RateResponse rateItem(long itemId, int rate, String token);

    RateResponse getCurrentRate(long itemId, String token);

}
