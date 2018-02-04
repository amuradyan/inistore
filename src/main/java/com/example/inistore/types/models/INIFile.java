package com.example.inistore.types.models;

import com.example.inistore.types.specs.INIFileRowSpec;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * Created by spectrum on 2/2/2018.
 */
@Entity
@Table(name = "file")
public class INIFile implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  private String name;

  @OneToMany(cascade = CascadeType.ALL,
  fetch = FetchType.LAZY, mappedBy = "file")
  private Set<INIFileRow> rows = new HashSet<>();

  public INIFile() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<INIFileRow> getRows() {
    return rows;
  }

  public void setRows(Set<INIFileRow> rows) {
    this.rows = rows;
  }

  public void addRow(INIFileRow iniFileRow) {
    iniFileRow.setFile(this);
    rows.add(iniFileRow);
  }

  @Override
  public String toString() {
    return "INIFile{" +
        "name='" + name + '\'' +
        ", rows=" + rows +
        '}';
  }
}
