package com.dailycodebuffer.springbootdemo.controller;

import com.dailycodebuffer.springbootdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HomeController {
    @RequestMapping(value = "/abc", method = RequestMethod.GET)
    public String home() {
        return "hello world";
    }

    @GetMapping("/user")
    public User user() {
        User user = new User();
        user.setId("1");
        user.setName("toshi");
        user.setEmailId("arai@tagbangers.co.jp");

        return user;
    }

    @GetMapping("/{id}/{id2}")
    public String pathVariables(@PathVariable String id, @PathVariable("id2") String name) {
        return "The path variable is:" + id + ":" + name;
    }

    @GetMapping("/requestParam")
    public String requestParams(@RequestParam String name,
                                @RequestParam(name = "email", required = false, defaultValue = "") String emailId){
        return "Your name is " + name + " and EmailId is " + emailId;
    }
}
