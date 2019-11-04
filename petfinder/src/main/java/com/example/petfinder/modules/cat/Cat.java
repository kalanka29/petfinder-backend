package com.example.petfinder.modules.cat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Cat{
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