package com.example.petfinder.repository;


import com.example.petfinder.models.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DogRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
//    @Qualifier("fixed-enterprise-named-param-jdbc")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private String type = "dog";

    public List<Dog> findAllDogs(){

        String sql = "select * from animals where type =? ";

        return jdbcTemplate.query(sql, new Object[]{type},(ResultSet rs, int rowNum)->{
            Dog dog = new Dog();
            dog.setId(rs.getInt("id"));
            dog.setAge(rs.getString("age"));
            dog.setBehaviour(rs.getString("behaviour"));
            dog.setBreed(rs.getString("breed"));
            dog.setColor(rs.getString("color"));
            dog.setGender(rs.getString("gender"));
            dog.setImage(rs.getString("image"));
            dog.setLocation(rs.getString("location"));
            dog.setType(rs.getString("type"));
            dog.setName(rs.getString("name"));
            dog.setSize(rs.getString("size"));
            return dog;
        });
    } // findAllDogs()

    public List<Dog> findDogById(String id) {

        Map<String,String> queryparams = new HashMap<>();
        queryparams.put("id",id);
        queryparams.put("type",type);

        String sql = "select * from animals where type= :type and id= :id";

        return this.namedParameterJdbcTemplate.query(sql,queryparams,( rs, rowNum)-> {
            Dog dog = new Dog();
            dog.setId(rs.getInt("id"));
            dog.setAge(rs.getString("age"));
            dog.setBehaviour(rs.getString("behaviour"));
            dog.setBreed(rs.getString("breed"));
            dog.setColor(rs.getString("color"));
            dog.setGender(rs.getString("gender"));
            dog.setImage(rs.getString("image"));
            dog.setLocation(rs.getString("location"));
            dog.setType(rs.getString("type"));
            dog.setName(rs.getString("name"));
            dog.setSize(rs.getString("size"));
            return dog;
        });
    } // findDogById()

    public List<Dog> findDogsByFilter(Map<String, String> parameter) {
        parameter.put("type",type);
        StringBuilder sql = new StringBuilder("select * from animals where type= :type ");
        if(StringUtils.hasText(parameter.get("location"))){
            sql.append(" and location = :location");
        } if(StringUtils.hasText(parameter.get("age"))){
            sql.append(" and age = :age");
        } if(StringUtils.hasText(parameter.get("color"))){
            sql.append(" and color = :color");
        } if(StringUtils.hasText(parameter.get("gender"))){
            sql.append(" and gender = :gender");
        } if(StringUtils.hasText(parameter.get("behaviour"))){
            sql.append(" and behaviour = :behaviour");
        } if(StringUtils.hasText(parameter.get("breed"))){
            sql.append(" and breed = :breed");
        } if(StringUtils.hasText(parameter.get("size"))){
            sql.append(" and size = :size");
        }if(StringUtils.hasText(parameter.get("name"))){
            sql.append(" and name = :name");
        }

        return this.namedParameterJdbcTemplate.query(sql.toString(),parameter,( rs, rowNum)-> {
            Dog dog = new Dog();
            dog.setId(rs.getInt("id"));
            dog.setAge(rs.getString("age"));
            dog.setBehaviour(rs.getString("behaviour"));
            dog.setBreed(rs.getString("breed"));
            dog.setColor(rs.getString("color"));
            dog.setGender(rs.getString("gender"));
            dog.setImage(rs.getString("image"));
            dog.setLocation(rs.getString("location"));
            dog.setType(rs.getString("type"));
            dog.setName(rs.getString("name"));
            dog.setSize(rs.getString("size"));
            return dog;
        });
    } // findDogsByFilter()
} // class
