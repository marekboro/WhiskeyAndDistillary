package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(
            @RequestParam(name = "fromYear",required = false) Integer year) {
        if (year != null) {
            return new ResponseEntity<>(whiskyRepository.findWhiskiesByYearEquals(year), HttpStatus.OK);
        } else {
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }
    }

    @GetMapping(value = "/whiskies2")
    public ResponseEntity<List<Whisky>> getAllWhiskiesByDistilleryByAge(
            @RequestParam(name = "fromDist",required = false) Integer id,
            @RequestParam(name = "age",required = false) Integer age
    ){
        if(id !=null && age!=null){
            return new ResponseEntity<>(whiskyRepository.findWhiskiesByDistilleryIdEqualsAndAgeEquals(id,age),HttpStatus.OK);
        } else if(id !=null) {
            return new ResponseEntity<>(whiskyRepository.findWhiskeyByDistillery_IdEquals(id), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
        }


    }


}
