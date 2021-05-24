package com.Prana.Latifi.response;

import java.util.List;

public class HomeDataResponse {

  private List<CategoryResponseLevelTwo> categories;
  private List<HomeSpecialOffersResponse> specialOffers;
  private List<HomeSpecialOffersResponse> usersFavourites;

  public HomeDataResponse() {}

  public HomeDataResponse(
      List<CategoryResponseLevelTwo> categories,
      List<HomeSpecialOffersResponse> specialOffers,
      List<HomeSpecialOffersResponse> usersFavourites) {
    this.categories = categories;
    this.specialOffers = specialOffers;
    this.usersFavourites = usersFavourites;
  }

  public List<CategoryResponseLevelTwo> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryResponseLevelTwo> categories) {
    this.categories = categories;
  }

  public List<HomeSpecialOffersResponse> getSpecialOffers() {
    return specialOffers;
  }

  public void setSpecialOffers(List<HomeSpecialOffersResponse> specialOffers) {
    this.specialOffers = specialOffers;
  }

  public List<HomeSpecialOffersResponse> getUsersFavourites() {
    return usersFavourites;
  }

  public void setUsersFavourites(List<HomeSpecialOffersResponse> usersFavourites) {
    this.usersFavourites = usersFavourites;
  }
}
