package com.example.inistore.types.specs;

/**
 * Created by spectrum on 2/2/2018.
 */
public class INIFileRowSpec {

  private Integer key;
  private String value;

  public INIFileRowSpec() {
  }

  public Integer getKey() {
    return key;
  }

  public void setKey(Integer key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "INIFileRowSpec{" +
        "key='" + key + '\'' +
        ", value='" + value + '\'' +
        '}';
  }
}
