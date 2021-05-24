package com.Prana.Latifi.service.Impl;

import com.Prana.Latifi.entity.Category;
import com.Prana.Latifi.entity.Item;
import com.Prana.Latifi.exception.ForbiddenForYou;
import com.Prana.Latifi.exception.NoTokenInRequest;
import com.Prana.Latifi.jwt.JwtFactory;
import com.Prana.Latifi.jwt.UserRoleModel;
import com.Prana.Latifi.repository.CategoryRepo;
import com.Prana.Latifi.repository.ItemRepo;
import com.Prana.Latifi.repository.specificactions.ItemSpecification;
import com.Prana.Latifi.request.CategoryRequest;
import com.Prana.Latifi.response.*;
import com.Prana.Latifi.response.mapper.CategoryResponseLevelTwoMapper;
import com.Prana.Latifi.response.mapper.HomeSpecialOffersMapper;
import com.Prana.Latifi.response.mapper.ItemMapper;
import com.Prana.Latifi.response.mapper.ItemPaginationMapper;
import com.Prana.Latifi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

  @Autowired private CategoryRepo categoryRepo;
  @Autowired private JwtFactory jwtFactory;
  @Autowired private ItemRepo itemRepo;

  @Override
  public HomeDataResponse getHomeData(String token) {
    if (token == null || token.isEmpty()) {
      throw new NoTokenInRequest();
    }
    UserRoleModel userRoleModel = jwtFactory.parseToken(token);


    List<Category> categories = categoryRepo.findAll();
    List<CategoryResponseLevelTwo> categoryResponseLevelTwos =
        CategoryResponseLevelTwoMapper.convertAll(categories);

    List<Item> specialOffers = itemRepo.findAllBySpecialOfferAndAmountGreaterThan(true, 1L);
    List<HomeSpecialOffersResponse> specialOffersResponses =
        HomeSpecialOffersMapper.convertAll(specialOffers);

    List<Item> usersFavourite = itemRepo.findByOrderBySoldAmountDesc();
    List<HomeSpecialOffersResponse> usersFavouriteResponses =
        HomeSpecialOffersMapper.convertAll(usersFavourite);

    return new HomeDataResponse(
        categoryResponseLevelTwos, specialOffersResponses, usersFavouriteResponses);
  }

  @Override
  public ItemResponse add(
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
      String token) {

    if (token == null || token.isEmpty()) {
      throw new NoTokenInRequest();
    }
    UserRoleModel userRoleModel = jwtFactory.parseToken(token);
    if (!userRoleModel.getRole().equals("ADMIN")) {
      throw new ForbiddenForYou();
    }

    List<Category> categoryList = new ArrayList<>();
    for (CategoryRequest category : categories) {
      Category category1 = new Category();
      category1.setId(category.getId());
      categoryList.add(category1);
    }
    return ItemMapper.convert(
        itemRepo.save(
            new Item(
                title,
                description,
                duration,
                howToUse,
                usingTip,
                usingDanger,
                secondTip,
                icon,
                image,
                price,
                active,
                amount,
                specialOffer,
                discount,
                soldAmount,
                categoryList,
                0,
                0)));
  }

  @Override
  public ItemResponse edit(
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
      String token) {

    if (token == null || token.isEmpty()) {
      throw new NoTokenInRequest();
    }
    UserRoleModel userRoleModel = jwtFactory.parseToken(token);
    if (!userRoleModel.getRole().equals("ADMIN")) {
      throw new ForbiddenForYou();
    }

    List<Category> categoryList = new ArrayList<>();
    for (CategoryRequest category : categories) {
      Category category1 = new Category();
      category1.setId(category.getId());
      categoryList.add(category1);
    }

    Item founded = itemRepo.findById(id).get();
    founded.setTitle(title);
    founded.setDescription(description);
    founded.setDuration(duration);
    founded.setHowToUse(howToUse);
    founded.setUsingTip(usingTip);
    founded.setSecondTip(secondTip);
    founded.setIcon(icon);
    founded.setImage(image);
    founded.setPrice(price);
    founded.setActive(active);
    founded.setAmount(amount);
    founded.setSpecialOffer(specialOffer);
    founded.setDiscount(discount);
    founded.setSoldAmount(soldAmount);
    founded.setCategories(categoryList);

    return ItemMapper.convert(itemRepo.save(founded));
  }

  @Override
  public ItemResponse getById(long id, String token) {
    if (token == null || token.isEmpty()) {
      throw new NoTokenInRequest();
    }
    UserRoleModel userRoleModel = jwtFactory.parseToken(token);


    return ItemMapper.convert(itemRepo.findById(id).get());
  }

  @Override
  public void deleteById(long id, String token) {
    if (token == null || token.isEmpty()) {
      throw new NoTokenInRequest();
    }
    UserRoleModel userRoleModel = jwtFactory.parseToken(token);
    if (!userRoleModel.getRole().equals("ADMIN")) {
      throw new ForbiddenForYou();
    }

    itemRepo.deleteById(id);
  }

  @Override
  public Page<ItemPaginationResponse> search(
      long id,
      String title,
      long lowPrice,
      long highPrice,
      List<Long> categryIds,
      Pageable pageable,
      String token) {
    if (token == null || token.isEmpty()) {
      throw new NoTokenInRequest();
    }
    UserRoleModel userRoleModel = jwtFactory.parseToken(token);

    ItemSpecification itemSpecification =
        new ItemSpecification(id, title, lowPrice, highPrice, categryIds);
    Page<Item> items = itemRepo.findAll(itemSpecification, pageable);
    return ItemPaginationMapper.convertAllPageable(items, pageable);
  }
}
