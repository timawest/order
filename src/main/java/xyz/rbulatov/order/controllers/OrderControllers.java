package xyz.rbulatov.order.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderControllers {
    @GetMapping("/index")
    public String doSomething(){
        return "index";
    }
}
