package com.Prana.Latifi.service.Impl;

import com.Prana.Latifi.entity.Category;
import com.Prana.Latifi.exception.ForbiddenForYou;
import com.Prana.Latifi.exception.NoTokenInRequest;
import com.Prana.Latifi.jwt.JwtFactory;
import com.Prana.Latifi.jwt.UserRoleModel;
import com.Prana.Latifi.repository.CategoryRepo;
import com.Prana.Latifi.response.CategoryResponse;
import com.Prana.Latifi.response.mapper.CategoryMapper;
import com.Prana.Latifi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryRepo categoryRepo;
  @Autowired
  private JwtFactory jwtFactory;

  @Override
  public CategoryResponse add(
      String title, String description, String icon, Category parent, String token) {
    if (token == null || token.isEmpty()) {
      throw new NoTokenInRequest();
    }
    UserRoleModel userRoleModel = jwtFactory.parseToken(token);
    if (!userRoleModel.getRole().equals("ADMIN")) {
      throw new ForbiddenForYou();
    }
    return CategoryMapper.convert(
        categoryRepo.save(new Category(title, description, icon, parent)));
  }

  @Override
  public CategoryResponse edit(
      long id, String title, String description, String icon, Category parent, String token) {
    if (token == null || token.isEmpty()) {
      throw new NoTokenInRequest();
    }
    UserRoleModel userRoleModel = jwtFactory.parseToken(token);
    if (!userRoleModel.getRole().equals("ADMIN")) {
      throw new ForbiddenForYou();
    }
    return CategoryMapper.convert(
        categoryRepo.save(new Category(id, title, description, icon, parent)));
  }

  @Override
  public CategoryResponse get(long id, String token) {
    if (token == null || token.isEmpty()) {
      throw new NoTokenInRequest();
    }
    UserRoleModel userRoleModel = jwtFactory.parseToken(token);
    if (!userRoleModel.getRole().equals("ADMIN")) {
      throw new ForbiddenForYou();
    }
    return CategoryMapper.convert(categoryRepo.findById(id).get());
  }

  @Override
  public List<CategoryResponse> getAll(String token) {
    return CategoryMapper.conertAll(categoryRepo.findAll());
  }

  @Override
  public boolean delete(long id, String token) {
    if (token == null || token.isEmpty()) {
      throw new NoTokenInRequest();
    }
    UserRoleModel userRoleModel = jwtFactory.parseToken(token);
    if (!userRoleModel.getRole().equals("ADMIN")) {
      throw new ForbiddenForYou();
    }
    categoryRepo.deleteById(id);
    return true;
  }
}
