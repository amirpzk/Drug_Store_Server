package com.Prana.Latifi.service;

import com.Prana.Latifi.entity.Category;
import com.Prana.Latifi.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse add(String title, String description, String icon, Category parent, String token);

    CategoryResponse edit(long id, String title, String description, String icon, Category parent, String token);

    CategoryResponse get(long id, String token);

    List<CategoryResponse> getAll(String token);

    boolean delete(long id, String token);

}
