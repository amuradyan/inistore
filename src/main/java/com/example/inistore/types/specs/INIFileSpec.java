package com.example.inistore.types.specs;

import java.util.List;

/**
 * Created by spectrum on 2/2/2018.
 */
public class INIFileSpec {

  private String name;
  private List<INIFileRowSpec> rows;

  public INIFileSpec() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<INIFileRowSpec> getRows() {
    return rows;
  }

  public void setRows(List<INIFileRowSpec> rows) {
    this.rows = rows;
  }

  @Override
  public String toString() {
    return "INIFileSpec{" +
        "name='" + name + '\'' +
        ", rows=" + rows +
        '}';
  }
}
