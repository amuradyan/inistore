package com.example.inistore.persistence;

import com.example.inistore.types.models.INIFileRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by spectrum on 2/2/2018.
 */
@Repository
public interface INIFileRowRepository extends JpaRepository<INIFileRow, Long> {

}
