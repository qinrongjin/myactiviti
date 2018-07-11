package cn.tiny77.controller;

import org.activiti.engine.ProcessEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private ProcessEngine processEngine;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
