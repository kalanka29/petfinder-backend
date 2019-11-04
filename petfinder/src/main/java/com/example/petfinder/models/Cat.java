package com.example.petfinder.models;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@ApiModel(description = "All details about the Cat ")
public class Cat {
    private int id;
    private String name;
    private String type;
    private String breed;
    private String age;
    private String color;
    private String image;
    private String location;
    private String gender;
    private String size;
    private String behaviour;
}