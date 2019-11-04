package com.example.petfinder.service;


import com.example.petfinder.models.Dog;
import com.example.petfinder.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DogService {
    @Autowired
    private DogRepository dogRepository;

    public List<Dog> findAllDogs() {
        return  this.dogRepository.findAllDogs();
    } // findAllDogs()

    public List<Dog> findDogById(String id) {
        return this.dogRepository.findDogById(id);
    } // findDogById()

    public List<Dog> findDogsByFilter(String name,String breed,String age,String color,String location,String gender,String size,String behaviour) {
        Map<String, String> parameter =new HashMap<>();
        parameter.put("name",name);
        parameter.put("breed",breed);
        parameter.put("age",age);
        parameter.put("color",color);
        parameter.put("location",location);
        parameter.put("gender",gender);
        parameter.put("size",size);
        parameter.put("behaviour",behaviour);
        return  this.dogRepository.findDogsByFilter(parameter);
    } //findDogsByFilter()
} // class
