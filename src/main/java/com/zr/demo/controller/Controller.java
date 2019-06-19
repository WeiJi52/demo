package com.zr.demo.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
	 @GetMapping(value = "/hello")
	    public String hello(Model model) {
	        String name = "jiangbei";
	        model.addAttribute("name", name);
	        return "hello";
	    }
}
