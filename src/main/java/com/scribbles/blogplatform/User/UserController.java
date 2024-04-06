package com.scribbles.blogplatform.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.*;
import java.util.Objects;

@Controller

public class UserController {
    @GetMapping
    public String showLoginForm(){
        return "login";
    }
    @PostMapping(value="/login",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String Login(
            @RequestBody MultiValueMap<String,String>data,
            HttpServletRequest request
            ){
        String userId = data.getFirst("username");
        String password = data.getFirst("password");
        System.out.println(userId + ":" + password);
        request.getSession().setAttribute("UserId",userId);
        return "redirect:/blogs";
    }
}
