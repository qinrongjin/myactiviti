package cn.tiny77.controller;

import cn.tiny77.model.dto.UserDTO;
import cn.tiny77.service.UserService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    @Qualifier(value = "root")
    private UserDTO root;

    @GetMapping("/login")
    public String loginGet(){
        return "user/login";
    }

    @PostMapping("/login")
    public String loginPost(HttpServletRequest request, UserDTO user){
        if(user.getUsername().equals("root") && user.getPassword().equals("root")){
            request.getSession().setAttribute("user", root);
            return "user/";
        }
        user = userService.checkLogin(user);
        if(user != null){
            request.getSession().setAttribute("user", user);
            return "index";
        }else{
            return "user/login";
        }
    }

    @GetMapping
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "index";
    }



}
