package com.Prana.Latifi.controller;

import com.Prana.Latifi.helper.ResponseHelper;
import com.Prana.Latifi.request.ProfileRequest;
import com.Prana.Latifi.service.ProfileService;
import com.Prana.Latifi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

  @Autowired private ProfileService profileService;
  @Autowired private UserService userService;

  @PostMapping(value = "/edit")
  public ResponseEntity editProfile(
      @RequestBody ProfileRequest profileRequest, @RequestParam String token) {
    return ResponseHelper.response(
        profileService.update(
            profileRequest.getAvatar(),
            profileRequest.getFirstName(),
            profileRequest.getLastName(),
            token));
  }

  @GetMapping(value = "/add-remove-favourite")
  public ResponseEntity addRemoveFavourite(
      @RequestParam long itemId, @RequestParam String token) {
    profileService.addRemoveFavourtie(itemId, token);
    return ResponseHelper.response(true);
  }

  @GetMapping(value = "/get-favourites")
  public ResponseEntity getFavourites(@RequestParam String token) {
    return ResponseHelper.response(profileService.getFavourites(token));
  }
}
