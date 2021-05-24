package com.Prana.Latifi.response.mapper;

import com.Prana.Latifi.entity.Category;
import com.Prana.Latifi.response.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryMapper {

  public static CategoryResponse convert(Category category) {
    if (category == null) {
      return null;
    }
    return new CategoryResponse(
        category.getId(), category.getTitle(), category.getDescription(), category.getIcon(), null);
  }

  public static List<CategoryResponse> conertAll(List<Category> categories) {
    List<CategoryResponse> responses = new ArrayList<>();
    if (categories == null) {
      return responses;
    }
    for (Category category : categories) {
      responses.add(convert(category));
    }
    return responses;
  }
}
