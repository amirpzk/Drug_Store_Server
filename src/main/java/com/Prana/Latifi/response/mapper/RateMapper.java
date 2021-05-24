package com.Prana.Latifi.response.mapper;

import com.Prana.Latifi.entity.Rate;
import com.Prana.Latifi.response.RateResponse;

import java.util.ArrayList;
import java.util.List;

public class RateMapper {

  public static RateResponse convert(Rate rate) {
    if (rate == null){
      return null;
    }
    return new RateResponse(rate.getId(), rate.getUsername(), rate.getItemId(), rate.getRate());
  }

  public static List<RateResponse> convertAll(List<Rate> rates) {
    List<RateResponse> responses = new ArrayList<>();
    for (Rate rate : rates) {
      responses.add(convert(rate));
    }
    return responses;
  }
}
