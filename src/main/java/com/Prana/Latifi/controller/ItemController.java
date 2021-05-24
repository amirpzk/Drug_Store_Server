package com.Prana.Latifi.controller;

import com.Prana.Latifi.helper.ResponseHelper;
import com.Prana.Latifi.request.ItemRequest;
import com.Prana.Latifi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

  @Autowired private ItemService itemService;

  @GetMapping(value = "/home")
  public ResponseEntity homedata(@RequestParam String token) {
    return ResponseHelper.response(itemService.getHomeData(token));
  }

  @PostMapping(value = "/add")
  public ResponseEntity addItem(
      @RequestBody ItemRequest request, @RequestParam String token) {
    return ResponseHelper.response(
        itemService.add(
            request.getTitle(),
            request.getDescription(),
            request.getAmountInShop(),
            request.getDuration(),
            request.getHowToUse(),
            request.getUsingTip(),
            request.getUsingDanger(),
            request.getSecondTip(),
            request.getIcon(),
            request.getImage(),
            request.getPrice(),
            request.isActive(),
            request.getAmount(),
            request.isSpecialOffer(),
            request.getDiscount(),
            request.getSoldAmount(),
            request.getCategories(),
            token));
  }

  @PutMapping(value = "/edit")
  public ResponseEntity editItem(
          @RequestBody ItemRequest request, @RequestParam String token) {
    return ResponseHelper.response(
            itemService.edit(
                    request.getId(),
                    request.getTitle(),
                    request.getDescription(),
                    request.getAmountInShop(),
                    request.getDuration(),
                    request.getHowToUse(),
                    request.getUsingTip(),
                    request.getUsingDanger(),
                    request.getSecondTip(),
                    request.getIcon(),
                    request.getImage(),
                    request.getPrice(),
                    request.isActive(),
                    request.getAmount(),
                    request.isSpecialOffer(),
                    request.getDiscount(),
                    request.getSoldAmount(),
                    request.getCategories(),
                    token));
  }

  @GetMapping(value = "/get-by-id")
  public ResponseEntity getById(@RequestParam long id, @RequestParam String token){
    return ResponseHelper.response(
            itemService.getById(id, token)
    );
  }

  @DeleteMapping(value = "/delete-by-id")
  public ResponseEntity deleteById(@RequestParam long id, @RequestParam String token){
    itemService.deleteById(id, token);
    return ResponseHelper.response(true);
  }

  @GetMapping(value = "/pageable")
  public ResponseEntity getPageable(
          @RequestParam(defaultValue = "0") long id,
          @RequestParam(required = false) String title,
          @RequestParam(required = false) long lowPrice,
          @RequestParam(required = false) long highPrice,
          @RequestParam(required = false) List<Long> categoryIds,
          Pageable pageable,
          @RequestParam String token) {
    return ResponseHelper.response(
            itemService.search(id, title, lowPrice, highPrice, categoryIds, pageable, token));
  }
}
