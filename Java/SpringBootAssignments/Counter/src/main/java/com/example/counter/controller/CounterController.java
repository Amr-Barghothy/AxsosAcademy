package com.example.counter.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {

    @RequestMapping("/")
    public String index(HttpSession session) {
        if(session.getAttribute("count")==null){
            session.setAttribute("count",0);
        }else{
            int x=(int) session.getAttribute("count")+1;
            session.setAttribute("count",x);
        }
        return "index.jsp";
    }
    @RequestMapping("/counter")
    public String counter() {
        return "Counter.jsp";
    }
}
