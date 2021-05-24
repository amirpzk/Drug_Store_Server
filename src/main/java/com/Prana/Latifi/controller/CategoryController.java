package com.Prana.Latifi.controller;

import com.Prana.Latifi.helper.ResponseHelper;
import com.Prana.Latifi.request.CategoryRequest;
import com.Prana.Latifi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @PostMapping(value = "/add")
  public ResponseEntity add(
          @RequestBody CategoryRequest categoryRequest, @RequestParam String token) {
    return ResponseHelper.response(
        categoryService.add(
            categoryRequest.getTitle(),
            categoryRequest.getDescription(),
            categoryRequest.getIcon(),
            categoryRequest.getParent(),
            token));
  }

  @PutMapping(value = "/edit")
  public ResponseEntity update(
      @RequestBody CategoryRequest categoryRequest,
      @RequestParam long id,
      @RequestParam String token) {
    return ResponseHelper.response(
        categoryService.edit(
            id,
            categoryRequest.getTitle(),
            categoryRequest.getDescription(),
            categoryRequest.getIcon(),
            categoryRequest.getParent(),
            token));
  }

  @GetMapping(value = "/get-by-id")
  public ResponseEntity getById(@RequestParam long id, @RequestParam String token) {
    return ResponseHelper.response(categoryService.get(id, token));
  }

  @GetMapping(value = "/get-all")
  public ResponseEntity getAll(@RequestParam String token) {
    return ResponseHelper.response(categoryService.getAll(token));
  }

  @DeleteMapping(value = "/delete-by-id")
  public ResponseEntity delete(@RequestParam long id, @RequestParam String token) {
    categoryService.delete(id, token);
    return ResponseHelper.response(true);
  }
}
