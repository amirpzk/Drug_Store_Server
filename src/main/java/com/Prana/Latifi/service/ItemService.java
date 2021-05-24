package com.Prana.Latifi.service;

import com.Prana.Latifi.request.CategoryRequest;
import com.Prana.Latifi.response.HomeDataResponse;
import com.Prana.Latifi.response.ItemPaginationResponse;
import com.Prana.Latifi.response.ItemResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {

  HomeDataResponse getHomeData(String token);

  ItemResponse add(
      String title,
      String description,
      long amountInShop,
      String duration,
      String howToUse,
      String usingTip,
      String usingDanger,
      String secondTip,
      String icon,
      String image,
      long price,
      boolean active,
      long amount,
      boolean specialOffer,
      long discount,
      long soldAmount,
      List<CategoryRequest> categories,
      String token);

  ItemResponse edit(
      long id,
      String title,
      String description,
      long amountInShop,
      String duration,
      String howToUse,
      String usingTip,
      String usingDanger,
      String secondTip,
      String icon,
      String image,
      long price,
      boolean active,
      long amount,
      boolean specialOffer,
      long discount,
      long soldAmount,
      List<CategoryRequest> categories,
      String token);

  ItemResponse getById(long id, String token);

  void deleteById(long id, String token);

  Page<ItemPaginationResponse> search(
      long id,
      String title,
      long lowPrice,
      long highPrice,
      List<Long> categryIds,
      Pageable pageable,
      String token);
}
