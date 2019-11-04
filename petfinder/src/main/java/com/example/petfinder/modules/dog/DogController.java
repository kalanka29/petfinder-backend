package com.example.petfinder.modules.dog;

import com.example.petfinder.modules.cat.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DogController {
    @Autowired
    private DogService dogService;
//    @Autowired
//    private Logger logger;


    @GetMapping("/dogs")
    public List<Dog> findAllDogs(){
        return this.dogService.findAllDogs();
    } // findAllDogs()

    @GetMapping("/dogs/{id}")
    public List<Dog> findDogById(@PathVariable String id){
//        logger.info("cat id:[{}]",id);
        return this.dogService.findDogById(id);
    } // findDogById()

    @GetMapping("/dogs/filter")
    public List<Dog> findDogssByFilter(@RequestParam Map<String,String> parameter){
        return this.dogService.findDogsByFilter(parameter);
    } // findDogssByFilter()
} //class
