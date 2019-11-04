package com.example.petfinder.controller;


import com.example.petfinder.models.Cat;
import com.example.petfinder.service.CatService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/api")
@Api(value = "Cat finder system", description = "Find cats by their id and certain filters ")
public class CatController {

    @Autowired
    private CatService catService;


    @ApiOperation(value = "View a list of available cats", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/cats")
    public List<Cat> findAllCats() {
        log.info("get all cats");
        return this.catService.findAllCats();
    } // findAllCats()

    @ApiOperation(value = "Get a Cat by Id")
    @GetMapping("/cats/{id}")
    public List<Cat> findCatById(@PathVariable String id) {
        log.info("get cat by id:[{}]", id);
        return this.catService.findCatById(id);
    } // findCatById()

    @ApiOperation(value = "View list of  Cats by filters")
    @GetMapping("/cats/filter")
    public List<Cat> findCatByFilter(
            @RequestParam(value = "location", required = false) String location,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "breed", required = false) String breed,
            @RequestParam(value = "color", required = false) String color,
            @RequestParam(value = "age", required = false) String age,
            @RequestParam(value = "gender", required = false) String gender,
            @RequestParam(value = "size", required = false) String size,
            @RequestParam(value = "behaviour", required = false) String behaviour)
    {
        log.info("get cats by filter => location:[{}],name:[{}],breed:[{}],age:[{}],color:[{}],gender:[{}],size:[{}]," +
                        "behaviour:[{}]",
                location,name,breed,age,color,gender,size,behaviour
        );
        return this.catService.findCatsByFilter(name, breed, age, color, location, gender, size, behaviour);
    } // findCatByFilter
} // class
