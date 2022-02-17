package cesi.di.formationspring.controller;

import cesi.di.formationspring.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@ResponseBody
public class HomeController {

    @RequestMapping("/")
    public String getHome(Model model) {
        Person p = new Person("toto", "tata");
        model.addAttribute("person", p);
        return "home";
    }

    @RequestMapping("/second")
    public String getSecond(Model model) {
        return "second";
    }
}
