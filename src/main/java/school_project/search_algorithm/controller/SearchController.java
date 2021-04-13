package school_project.search_algorithm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import school_project.search_algorithm.search.SearchOption;
import school_project.search_algorithm.search.SearchResult;
import school_project.search_algorithm.service.SearchService;

import java.util.List;

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
    public String searchResult(@ModelAttribute SearchOption searchOpt, Model model) {
        List<SearchResult> result = search.result(searchOpt);
        model.addAttribute("resultList", result);
        return "result";
    }

    @GetMapping("result")
    public String resultList(Model model) {
        model.addAttribute("resultList", search.getResult());
        return "result";
    }
}