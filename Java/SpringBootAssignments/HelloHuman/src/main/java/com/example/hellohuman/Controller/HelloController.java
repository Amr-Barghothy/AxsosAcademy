package com.example.hellohuman.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/")
    public String index(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "last_name", required = false) String last_name, @RequestParam(value = "times", required = false) Integer times) {
        if (name != null && last_name == null && times == null) {
            return "Hello " + name;
        }
        if (name != null && last_name != null && times == null) {
            return "Hello " + name + " " + last_name;
        }
        if (name != null && last_name == null && times > 0) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < times; i++) {
                temp.append(" Hello ").append(name);
            }
            return temp.toString();
        }
        return "Hello Human";
    }

}