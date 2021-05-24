package com.Prana.Latifi.response.mapper;

import com.Prana.Latifi.entity.Profile;
import com.Prana.Latifi.response.ProfileResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProfileMapper {

  public static ProfileResponse convert(Profile profile) {

    if (profile == null) {
      return null;
    }

    return new ProfileResponse(
        profile.getId(),
        profile.getAvatar(),
        profile.getFirstName(),
        profile.getLastName(),
        profile.getType(),
        TransactionMapper.convertAll(profile.getTransactions()),
        CompanyDetailMapper.convert(profile.getCompanyDetail()));
  }

  public static List<ProfileResponse> convertAll(List<Profile> profiles) {
    List<ProfileResponse> responses = new ArrayList<>();
    if (profiles == null) {
      return responses;
    }
    for (Profile profile : profiles) {
      responses.add(convert(profile));
    }
    return responses;
  }
}
