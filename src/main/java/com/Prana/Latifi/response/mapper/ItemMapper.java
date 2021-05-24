package com.Prana.Latifi.response.mapper;

import com.Prana.Latifi.entity.Item;
import com.Prana.Latifi.response.ItemResponse;

import java.util.*;

public class ItemMapper {

  public static ItemResponse convert(Item item) {
    if (item == null) {
      return null;
    }
    return new ItemResponse(
        item.getId(),
        item.getTitle(),
        item.getDescription(),
        item.getDuration(),
        item.getHowToUse(),
        item.getUsingTip(),
        item.getUsingDanger(),
        item.getSecondTip(),
        item.getIcon(),
        item.getImage(),
        item.getPrice(),
        item.isActive(),
        item.getAmount(),
        item.isSpecialOffer(),
        item.getDiscount(),
        CategoryMapper.conertAll(item.getCategories()),
        item.getTotalAMountOfRates(),
        item.getTotalRate());
  }

  public static List<ItemResponse> convertAll(List<Item> items) {
    List<ItemResponse> responses = new ArrayList<>();
    for (Item item : items) {
      responses.add(convert(item));
    }
    return responses;
  }

  public static Map<String, ItemResponse> convertTransactionForm(Map<String, Item> itemMap) {
    Map<String, ItemResponse> responeMap = new HashMap<>();
    for (String s : itemMap.keySet()) {
      responeMap.put(s, convert(itemMap.get(s)));
    }
    return responeMap;
  }
}
