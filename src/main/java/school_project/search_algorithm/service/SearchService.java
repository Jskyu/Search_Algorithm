package school_project.search_algorithm.service;

import school_project.search_algorithm.search.SearchOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SearchService {

    private final List<Integer> list = new ArrayList<>();

    public SearchService() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10000; i++) {
            stack.add(i + 1);
        }

        while (stack.size() > 0) {
            int rand = (int) (Math.random() * stack.size());
            list.add(stack.remove(rand));
        }
    }

    public String notSortedLinearSearch(int key) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key) return key + "값의 Array Index 위치 : " + i;
        }
        return "찾지 못함";
    }

    public String sortedLinearSearch(int key) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key)
                return key + "값의 Array Index 위치 : " + i;
            else if (list.get(i) > key) return "찾지 못함";
        }
        return "찾지 못함";
    }

    public String binarySearch(int key) {
        int left = 0;
        int right = list.size() - 1;
        int mid;

        while (left <= right) {

            mid = (left + right) / 2;
            if (key == (list.get(mid))) {
                return key + "값의 Array Index 위치 : " + mid;
            }
            if (list.get(mid) <= key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return "찾지 못함";
    }

    public String result(SearchOption searchOpt) {
        switch (searchOpt.getOpt()) {
            case "순차탐색":
                return this.notSortedLinearSearch(searchOpt.getKey());
            case "이진탐색":
                return this.binarySearch(searchOpt.getKey());
            default:
                throw new IllegalArgumentException();
        }
    }
}