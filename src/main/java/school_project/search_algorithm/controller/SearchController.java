package school_project.search_algorithm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import school_project.search_algorithm.search.SearchOption;
import school_project.search_algorithm.service.SearchService;

@Controller
@RequestMapping("/search")
@Slf4j
public class SearchController {

    private final SearchService search = new SearchService();

    @GetMapping
    public String search(Model model) {
        log.info("검색 화면");
        model.addAttribute("searchOpt", new SearchOption());
        return "search";
    }

    @PostMapping("result")
    public String searchResult(@ModelAttribute SearchOption searchOpt) {
        System.out.println(search.result(searchOpt).toString());
        return "result";
    }
}