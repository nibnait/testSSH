package com.nibnait.controller;

import com.nibnait.entity.User;
import com.nibnait.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * Created by nibnait on 2016/8/19.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/getAllUser")
    public String getAllUser(HttpServletRequest request){

        request.setAttribute("userList", userService.getAllUser());

        return "/index";
    }

    @RequestMapping("/getUser")
    public String getUser(String id,HttpServletRequest request){

        request.setAttribute("user", userService.getUser(id));

        return "/editUser";
    }

    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "/addUser";
    }

    @RequestMapping("/addUser")
    public String addUser(User user, HttpServletRequest request){

        user.setId(UUID.randomUUID().toString());
        userService.addUser(user);

        return "redirect:/user/getAllUser";
    }

    @RequestMapping("/delUser")
    public void delUser(String id,HttpServletResponse response){

        String result = "{\"result\":\"error\"}";

        if(userService.delUser(id)){
            result = "{\"result\":\"success\"}";
        }

        response.setContentType("application/json");

        try {
            PrintWriter out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user,HttpServletRequest request){

        if(userService.updateUser(user)){
            user = userService.getUser(user.getId());
            request.setAttribute("user", user);
            return "redirect:/user/getAllUser";
        }else{
            return "/error";
        }
    }

}
