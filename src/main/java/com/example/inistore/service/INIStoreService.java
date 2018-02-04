package com.example.inistore.service;

import com.example.inistore.persistence.INIFileRepository;
import com.example.inistore.persistence.INIFileRowRepository;
import com.example.inistore.types.models.INIFile;
import com.example.inistore.types.models.INIFileRow;
import com.example.inistore.types.specs.INIFileRowSpec;
import com.example.inistore.types.specs.INIFileSpec;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by spectrum on 2/2/2018.
 */
@Service
public class INIStoreService {

  final INIFileRepository iniFileRepository;
  final INIFileRowRepository iniFileRowRepository;

  @Autowired
  public INIStoreService(INIFileRepository iniFileRepository, INIFileRowRepository iniFileRowRepository) {
    this.iniFileRepository = iniFileRepository;
    this.iniFileRowRepository = iniFileRowRepository;
  }

  public INIFile create(INIFileSpec iniFileSpec) {
    INIFile iniFile = createFromSpec(iniFileSpec);
    iniFile = iniFileRepository.save(iniFile);
    return iniFile;
  }

  public List<INIFile> get(String value) {
    return iniFileRepository.findByValue(value);
  }

  public void delete(Long fileId) {
    iniFileRepository.deleteById(fileId);
  }

  private INIFile createFromSpec(INIFileSpec iniFileSpec) {
    INIFile iniFile = new INIFile();

    iniFile.setName(iniFileSpec.getName());

    for (INIFileRowSpec iniFileRowSpec : iniFileSpec.getRows()) {
      iniFile.addRow(new INIFileRow(iniFileRowSpec.getKey(), iniFileRowSpec.getValue()));
    }

    return iniFile;
  }
}
