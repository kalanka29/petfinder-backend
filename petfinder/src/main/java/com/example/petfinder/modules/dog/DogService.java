package com.example.petfinder.modules.dog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DogService {
    @Autowired
    private DogRepository dogRepository;

//    @Autowired
//    private Logger logger;

    public List<Dog> findAllDogs() {
//        logger.info("find all cats");
        return  this.dogRepository.findAllDogs();
    } // findAllDogs()

    public List<Dog> findDogById(String id) {
//        logger.info("find vcat by id:[{}]",id);
        return this.dogRepository.findDogById(id);
    }

    public List<Dog> findDogsByFilter(Map<String, String> parameter) {
        return  this.dogRepository.findDogsByFilter(parameter);
    } //findDogsByFilter()
} // class
