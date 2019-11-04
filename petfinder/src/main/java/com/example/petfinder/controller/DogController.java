package com.example.petfinder.controller;


import com.example.petfinder.models.Dog;
import com.example.petfinder.service.DogService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/api")
@Api(value = "Dog finder ", description = "Find dogs by  id and certain filters ")
public class DogController {
    @Autowired
    private DogService dogService;

    @ApiOperation(value = "View a list of available dogs", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/dogs")
    public List<Dog> findAllDogs(){
        log.info("retrieve all dogs");
        return this.dogService.findAllDogs();
    } // findAllDogs()

    @ApiOperation(value = "View a details of a dogs by id", response = List.class)
    @GetMapping("/dogs/{id}")
    public List<Dog> findDogById(
            @ApiParam(value = "Dog id from which Dog object will retrieve", required = true)  @PathVariable String id){
        log.info("retrieve dog by id:[{}]",id);
        return this.dogService.findDogById(id);
    } // findDogById()

    @ApiOperation(value = "View list of  dogs by filters", response = List.class)
    @GetMapping("/dogs/filter")
    public List<Dog> findDogsByFilter(
            @RequestParam ( value="location",required = false) String location,
            @RequestParam (value="name",required = false) String name,
            @RequestParam (value="breed",required = false) String breed,
            @RequestParam (value="color",required = false) String color,
            @RequestParam (value="age",required = false) String age,
            @RequestParam (value="gender",required = false) String gender,
            @RequestParam (value="size",required = false) String size,
            @RequestParam (value="behaviour",required = false) String behaviour)
            {
                log.info("get dogs by filter => location:[{}],name:[{}],breed:[{}],age:[{}],color:[{}]," +
                                "gender:[{}],size:[{}],behaviour:[{}]",
                        location,name,breed,age,color,gender,size,behaviour
                );
        return this.dogService.findDogsByFilter(name, breed, age, color, location, gender, size, behaviour);
    } // findDogsByFilter()
} //class
