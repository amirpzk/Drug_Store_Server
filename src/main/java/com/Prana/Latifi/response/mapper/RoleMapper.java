package com.Prana.Latifi.response.mapper;

import com.Prana.Latifi.entity.Role;
import com.Prana.Latifi.response.RoleResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleMapper {

  public static RoleResponse convert(Role role) {
    if (role == null){
      return null;
    }
    return new RoleResponse(role.getId(), role.getName());
  }

  public static List<RoleResponse> convertAll(List<Role> roles) {

    List<RoleResponse> responses = new ArrayList<>();
    if (roles == null){
      return responses;
    }
    for (Role role : roles) {
      responses.add(convert(role));
    }
    return responses;
  }
}
