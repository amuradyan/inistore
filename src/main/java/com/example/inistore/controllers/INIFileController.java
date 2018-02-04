package com.example.inistore.controllers;

import com.example.inistore.service.INIStoreService;
import com.example.inistore.types.models.INIFile;
import com.example.inistore.types.specs.INIFileSpec;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class INIFileController {

  private final INIStoreService iniStoreService;

  @Autowired
  public INIFileController(INIStoreService iniStoreService) {
    this.iniStoreService = iniStoreService;
  }

  @PostMapping("files")
  public INIFile create(@RequestBody INIFileSpec iniFileSpec) {
    return iniStoreService.create(iniFileSpec);
  }

  @GetMapping("files")
  public List<INIFile> get(@RequestParam(required = false) String value) {
    return iniStoreService.get(value);
  }

  @DeleteMapping("files/{fileId}")
  public void delete(@PathVariable Long fileId) {
    iniStoreService.delete(fileId);
  }
}
