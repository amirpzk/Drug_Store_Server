package com.Prana.Latifi.controller;

import com.Prana.Latifi.helper.ResponseHelper;
import com.Prana.Latifi.request.RoleRequest;
import com.Prana.Latifi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

  @Autowired
  private RoleService roleService;

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public ResponseEntity add(@RequestBody RoleRequest request, @RequestParam String token) {
    return ResponseHelper.response(
        roleService.add(request.getName(), request.getDescription(), token));
  }

  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public ResponseEntity update(@RequestBody RoleRequest request, @RequestParam String token) {
    return ResponseHelper.response(
        roleService.update(request.getId(), request.getName(), request.getDescription(), token));
  }

  @RequestMapping(value = "/find", method = RequestMethod.GET)
  public ResponseEntity find(@RequestParam long id, @RequestParam String token) {
    return ResponseHelper.response(roleService.findOne(id, token));
  }

  @RequestMapping(value = "/find-all", method = RequestMethod.GET)
  public ResponseEntity findAll(@RequestParam String token) {
    return ResponseHelper.response(roleService.findAll(token));
  }

  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  public ResponseEntity delete(@RequestParam long id, @RequestParam String token) {
    roleService.delete(id, token);
    return ResponseHelper.response(true);
  }
}
