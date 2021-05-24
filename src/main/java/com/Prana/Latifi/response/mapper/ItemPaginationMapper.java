package com.Prana.Latifi.response.mapper;

import com.Prana.Latifi.entity.Item;
import com.Prana.Latifi.response.CategoryResponse;
import com.Prana.Latifi.response.ItemPaginationResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class ItemPaginationMapper {

  public static ItemPaginationResponse convert(Item item) {
    if (item == null){
      return null;
    }
    List<CategoryResponse> categoryResponses = CategoryMapper.conertAll(item.getCategories());
    return new ItemPaginationResponse(
        item.getId(),
        item.getTitle(),
        item.getDescription(),
        item.getIcon(),
        item.getImage(),
        item.getPrice(),
        item.isActive(),
        item.getAmount(),
        item.isSpecialOffer(),
        item.getDiscount(),
        categoryResponses,
        item.getTotalAMountOfRates(),
        item.getTotalRate());
  }

  public static Page<ItemPaginationResponse> convertAllPageable(Page<Item> items, Pageable pageable) {
    List<ItemPaginationResponse> responses = new ArrayList<>();
    for (Item item : items) {
      responses.add(convert(item));
    }
    return new PageImpl<>(responses, pageable, items.getTotalElements());
  }
}
