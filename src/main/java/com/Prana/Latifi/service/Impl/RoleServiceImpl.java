package com.Prana.Latifi.service.Impl;

import com.Prana.Latifi.entity.Role;
import com.Prana.Latifi.exception.ForbiddenForYou;
import com.Prana.Latifi.exception.NoTokenInRequest;
import com.Prana.Latifi.jwt.JwtFactory;
import com.Prana.Latifi.jwt.UserRoleModel;
import com.Prana.Latifi.repository.RoleRepo;
import com.Prana.Latifi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleRepo roleRepository;
  @Autowired
  private JwtFactory jwtFactory;

  @Override
  public Role add(String name, String description, String token) {
    if (token == null || token.isEmpty()) {
      throw new NoTokenInRequest();
    }
    UserRoleModel userRoleModel = jwtFactory.parseToken(token);
    if (!userRoleModel.getRole().equals("ADMIN")) {
      throw new ForbiddenForYou();
    }
    return roleRepository.save(new Role(name, description));
  }

  @Override
  public Role update(long id, String name, String description, String token) {
    if (token == null || token.isEmpty()) {
      throw new NoTokenInRequest();
    }
    UserRoleModel userRoleModel = jwtFactory.parseToken(token);
    if (!userRoleModel.getRole().equals("ADMIN")) {
      throw new ForbiddenForYou();
    }
    return roleRepository.save(new Role(id, name, description));
  }

  @Override
  public Role findOne(long id, String token) {
    if (token == null || token.isEmpty()) {
      throw new NoTokenInRequest();
    }
    UserRoleModel userRoleModel = jwtFactory.parseToken(token);
    if (!userRoleModel.getRole().equals("ADMIN")) {
      throw new ForbiddenForYou();
    }

    return roleRepository.findById(id).get();
  }

  @Override
  public List<Role> findAll(String token) {
    if (token == null || token.isEmpty()) {
      throw new NoTokenInRequest();
    }
    UserRoleModel userRoleModel = jwtFactory.parseToken(token);
    if (!userRoleModel.getRole().equals("ADMIN")) {
      throw new ForbiddenForYou();
    }
    return roleRepository.findAll();
  }

  @Override
  public void delete(long id, String token) {
    if (token == null || token.isEmpty()) {
      throw new NoTokenInRequest();
    }
    UserRoleModel userRoleModel = jwtFactory.parseToken(token);
    if (!userRoleModel.getRole().equals("ADMIN")) {
      throw new ForbiddenForYou();
    }

    roleRepository.deleteById(id);
  }
}
