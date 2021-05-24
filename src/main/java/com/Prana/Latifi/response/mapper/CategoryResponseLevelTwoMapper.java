package com.Prana.Latifi.response.mapper;


import com.Prana.Latifi.entity.Category;
import com.Prana.Latifi.response.CategoryResponseLevelTwo;

import java.util.ArrayList;
import java.util.List;

public class CategoryResponseLevelTwoMapper {

  public static CategoryResponseLevelTwo convert(Category category) {
    if (category == null) {
      return null;
    }
    return new CategoryResponseLevelTwo(
        category.getId(), category.getTitle(), category.getDescription(), category.getIcon());
  }

  public static List<CategoryResponseLevelTwo> convertAll(List<Category> categories) {
    List<CategoryResponseLevelTwo> responses = new ArrayList<>();
    for (Category category : categories) {
      responses.add(convert(category));
    }
    return responses;
  }
}
