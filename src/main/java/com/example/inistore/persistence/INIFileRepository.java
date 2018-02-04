package com.example.inistore.persistence;

import com.example.inistore.types.models.INIFile;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by spectrum on 2/2/2018.
 */
@Repository
public interface INIFileRepository extends JpaRepository<INIFile, Long> {

  @Query("select inif from INIFile inif join inif.rows r where (r.value = :value)")
  List<INIFile> findByValue(@Param("value") String value);
}
