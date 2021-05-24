package com.Prana.Latifi.service;


import com.Prana.Latifi.response.ProfileResponse;

import java.util.List;

public interface ProfileService {

    ProfileResponse update(String avatar, String firstName, String lastName, String token);

    boolean addRemoveFavourtie(long itemId, String token);

    List<Long> getFavourites(String token);
}
