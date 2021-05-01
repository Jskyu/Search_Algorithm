package school_project.search_algorithm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home() {
        log.info("서버 접속");
        return "redirect:home";
    }

    @GetMapping("home")
    public String main(){
        log.info("HOME");
        return "home";
    }
}