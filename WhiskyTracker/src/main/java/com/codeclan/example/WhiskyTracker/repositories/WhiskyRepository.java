package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findWhiskiesByYearEquals(Integer year);

    List<Whisky> findWhiskiesByDistilleryIdEqualsAndAgeEquals(Integer name,Integer age);

    List<Whisky> findWhiskeyByDistillery_IdEquals(Integer id);


}
