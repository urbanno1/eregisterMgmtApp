package edu.mum.cs.cs425.eregisterapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/eregister", "/eregister/home"})
    public  String home() {
        return "home/index";
    }
}
