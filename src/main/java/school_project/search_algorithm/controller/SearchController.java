package school_project.search_algorithm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import school_project.search_algorithm.dto.IndexResult;
import school_project.search_algorithm.dto.SearchOption;
import school_project.search_algorithm.dto.SearchResult;
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
        log.info(searchOpt.getOpt() + " 실행. 입력 값 : "+searchOpt.getKey());
        List<SearchResult> result = search.result(searchOpt);
        model.addAttribute("resultList", result);
        return "result";
    }

    @GetMapping("result")
    public String resultList(Model model) {
        log.info("검색 결과 조회");
        model.addAttribute("resultList", search.getResult());
        return "result";
    }

    @PostMapping("findArray")
    public String findArray(@ModelAttribute SearchOption searchOpt, Model model) {
        log.info(searchOpt.getOpt()+"리스트 "+ searchOpt.getKey() + "번 인덱스 조회");
        IndexResult findIndex = search.findIndex(searchOpt);
        model.addAttribute("result", findIndex);
        return "printFindIndex";
    }
}