package com.springboot.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.springboot.entity.UserEntity;
import com.springboot.service.LoginService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dhiraj
 * @date 09/01/19
 */
@RestController
@EnableAutoConfiguration
public class LoginServiceImpl implements LoginService{
    @Override
    public String userDetails() {
        ObjectMapper mapper = new ObjectMapper();
        UserEntity userEntity= new UserEntity();
        userEntity.setName("dhiraj");
        String jsonString="";
        try {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            jsonString = mapper.writeValueAsString(userEntity);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonString;


    }

    public static void main(String[] args) {
        SpringApplication.run(LoginServiceImpl.class,args);
    }
}
