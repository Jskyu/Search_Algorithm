package school_project.search_algorithm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import school_project.search_algorithm.dto.SearchOption;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home(@ModelAttribute SearchOption searchOpt){
        log.info("HOME");
        return "home";
    }
}