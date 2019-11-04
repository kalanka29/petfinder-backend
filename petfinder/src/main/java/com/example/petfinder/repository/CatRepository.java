package com.example.petfinder.repository;


import com.example.petfinder.models.Cat;
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
public class CatRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private String type = "cat";

    public List<Cat> findAllCats(){

        String sql = "select * from animals where type =? ";

        return jdbcTemplate.query(sql, new Object[]{type},(ResultSet rs, int rowNum)->{
            Cat cat = new Cat();
            cat.setId(rs.getInt("id"));
            cat.setAge(rs.getString("age"));
            cat.setBehaviour(rs.getString("behaviour"));
            cat.setBreed(rs.getString("breed"));
            cat.setColor(rs.getString("color"));
            cat.setGender(rs.getString("gender"));
            cat.setImage(rs.getString("image"));
            cat.setLocation(rs.getString("location"));
            cat.setType(rs.getString("type"));
            cat.setName(rs.getString("name"));
            cat.setSize(rs.getString("size"));
            return cat;
        });
    } // findAllCats()

    public List<Cat> findCatById(String id) {

        Map<String,String> queryparams = new HashMap<>();
        queryparams.put("id",id);
        queryparams.put("type",type);

        String sql = "select * from animals where type= :type and id= :id";

        return this.namedParameterJdbcTemplate.query(sql,queryparams,( rs, rowNum)-> {
            Cat cat = new Cat();
            cat.setId(rs.getInt("id"));
            cat.setAge(rs.getString("age"));
            cat.setBehaviour(rs.getString("behaviour"));
            cat.setBreed(rs.getString("breed"));
            cat.setColor(rs.getString("color"));
            cat.setGender(rs.getString("gender"));
            cat.setImage(rs.getString("image"));
            cat.setLocation(rs.getString("location"));
            cat.setType(rs.getString("type"));
            cat.setName(rs.getString("name"));
            cat.setSize(rs.getString("size"));
            return cat;
        });
    } // findCatById()

    public List<Cat> findCatsByFilter(Map<String, String> parameter) {
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
            Cat cat = new Cat();
            cat.setId(rs.getInt("id"));
            cat.setAge(rs.getString("age"));
            cat.setBehaviour(rs.getString("behaviour"));
            cat.setBreed(rs.getString("breed"));
            cat.setColor(rs.getString("color"));
            cat.setGender(rs.getString("gender"));
            cat.setImage(rs.getString("image"));
            cat.setLocation(rs.getString("location"));
            cat.setType(rs.getString("type"));
            cat.setName(rs.getString("name"));
            cat.setSize(rs.getString("size"));
            return cat;
        });
    } // findCatsByFilter()
} // class
