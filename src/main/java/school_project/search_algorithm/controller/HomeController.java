package school_project.search_algorithm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import school_project.search_algorithm.search.SearchOption;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@ModelAttribute SearchOption searchOpt){
        return "home";
    }
}