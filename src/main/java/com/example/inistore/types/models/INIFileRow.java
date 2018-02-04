package com.example.inistore.types.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by spectrum on 2/2/2018.
 */
@Entity
@Table(name = "row")
public class INIFileRow implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  @Column(name = "banali")
  private Integer key;

  @NotNull
  private String value;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "file_id", nullable = false)
  @JsonIgnore
  private INIFile file;

  public INIFileRow() {
  }

  public INIFileRow(@NotNull Integer key, @NotNull String value) {
    this.key = key;
    this.value = value;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public INIFile getFile() {
    return file;
  }

  public void setFile(INIFile file) {
    this.file = file;
  }

  public Long getId() {
    return id;
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
    return "INIFileRow{" +
        "key='" + key + '\'' +
        ", value='" + value + '\'' +
        '}';
  }
}
