package com.example.twodatasources.repository.datasource2;

import com.example.twodatasources.model.datasource2.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PupilRepository extends JpaRepository<Pupil, Long> {

}
