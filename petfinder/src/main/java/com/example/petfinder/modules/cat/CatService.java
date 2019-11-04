package com.example.petfinder.modules.cat;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Cat> findCatsByFilter(Map<String, String> parameter) {
        return  this.catRepository.findCatsByFilter(parameter);
    } //findCatsByFilter()
} // class
