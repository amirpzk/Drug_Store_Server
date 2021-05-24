package com.Prana.Latifi.response.mapper;

import com.Prana.Latifi.entity.User;
import com.Prana.Latifi.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMapper {

  public static UserResponse convert(User user) {
    if (user == null){
      return null;
    }
    return new UserResponse(
        user.getId(),
        user.getUsername(),
        user.getPassword(),
        user.getCreationDate(),
        RoleMapper.convertAll(user.getRoles()),
        ProfileMapper.convert(user.getProfile()));
  }

  public static List<UserResponse> convertAll(List<User> users) {
    List<UserResponse> responses = new ArrayList<>();
    if (users == null){
      return responses;
    }
    for (User user : users) {
      responses.add(convert(user));
    }
    return responses;
  }
}
