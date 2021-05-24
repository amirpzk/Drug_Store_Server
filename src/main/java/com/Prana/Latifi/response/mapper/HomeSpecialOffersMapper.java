package com.Prana.Latifi.response.mapper;

import com.Prana.Latifi.entity.Item;
import com.Prana.Latifi.response.HomeSpecialOffersResponse;

import java.util.ArrayList;
import java.util.List;

public class HomeSpecialOffersMapper {

  public static HomeSpecialOffersResponse convert(Item item) {
    if (item == null){
      return null;
    }
    return new HomeSpecialOffersResponse(
        item.getId(),
        item.getTitle(),
        item.getDuration(),
        item.getIcon(),
        item.getImage(),
        item.getPrice(),
        item.isActive(),
        item.getAmount(),
        item.getDiscount());
  }

  public static List<HomeSpecialOffersResponse> convertAll(List<Item> items) {
    List<HomeSpecialOffersResponse> responses = new ArrayList<>();
    for (Item item : items) {
      responses.add(convert(item));
    }
    return responses;
  }
}
