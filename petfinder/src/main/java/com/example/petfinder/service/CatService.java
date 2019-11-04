package com.example.petfinder.service;


import com.example.petfinder.models.Cat;
import com.example.petfinder.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CatService {

    @Autowired
    private CatRepository catRepository;

//    @Autowired
//    private Logger logger;

    public List<Cat> findAllCats() {
//        logger.info("find all cats");
        return  this.catRepository.findAllCats();
    } // findAllCats()

    public List<Cat> findCatById(String id) {
//        logger.info("find vcat by id:[{}]",id);
        return this.catRepository.findCatById(id);
    }

    public List<Cat> findCatsByFilter(String name,String breed,String age,String color,String location,String gender,String size,String behaviour) {
        Map<String, String> parameter = new HashMap<>();
        parameter.put("name",name);
        parameter.put("breed",breed);
        parameter.put("age",age);
        parameter.put("color",color);
        parameter.put("location",location);
        parameter.put("gender",gender);
        parameter.put("size",size);
        parameter.put("behaviour",behaviour);
        return  this.catRepository.findCatsByFilter(parameter);
    } //findCatsByFilter()
} // class
