package com.example.petfinder.modules.cat;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CatController {

    @Autowired
    private CatService catService;
//    @Autowired
//    private Logger logger;


    @GetMapping("/cats")
    public List<Cat> findAllCats(){

        return this.catService.findAllCats();
    } // findAllCats()

    @GetMapping("/cats/{id}")
    public List<Cat> findCatById(@PathVariable String id){
//        logger.info("cat id:[{}]",id);
        return this.catService.findCatById(id);
    } // findCatById()

    @GetMapping("/cats/filter")
    public List<Cat> findCatByFilter(@RequestParam Map<String,String> parameter){
        return this.catService.findCatsByFilter(parameter);
    } // findCatByFilter
} // class
