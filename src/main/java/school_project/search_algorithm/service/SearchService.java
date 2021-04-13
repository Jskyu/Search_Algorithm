package school_project.search_algorithm.service;

import school_project.search_algorithm.search.SearchOption;
import school_project.search_algorithm.search.SearchResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SearchService {

    private final int size = 10000;

    private final List<Integer> list = new ArrayList<>();
    List<Integer> sortList;
    private final int[] hash = new int[size];

    public SearchService() {
        //1~10000의 숫자를 랜덤하게 list에 입력
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            stack.add(i + 1);
        }
        while (stack.size() > 0) {
            int rand = (int) (Math.random() * stack.size());
            list.add(stack.remove(rand));
        }
        //정렬 리스트 입력
        sortList = list.stream().sorted().collect(Collectors.toList());

        //1~10000의 숫자를 해시 탐색법으로 입력
        for (int i = 0; i < size; i++) {
            this.set(i+1);
        }
    }

    public int notSortedLinearSearch(int key) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key) return i;
        }
        return -1;
    }

    public int sortedLinearSearch(List<Integer> list, int key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key)
                return i;
            else if (list.get(i) > key) return -1;
        }
        return -1;
    }

    public int binarySearch(List<Integer> list, int key) {
        int left = 0;
        int right = list.size() - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (key == (list.get(mid))) {
                return mid;
            }
            if (list.get(mid) <= key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int hashSearch(int key) {
        int idx = hash(key);

        if (this.hash[idx] == key) {
            return idx;
        } else {
            idx++;
            int i = 0;
            while (this.hash[idx] != key) {
                idx++;
                i++;
                if (idx == this.size) {
                    idx = 0;
                }
                if (i == this.size) {
                    return -1;
                }
            }
            return idx;
        }
    }

    public SearchResult result(SearchOption searchOpt) {
        String opt = searchOpt.getOpt();
        int key = searchOpt.getKey();

        switch (opt) {
            case "정렬 순차탐색":
                return new SearchResult("정렬 순차 탐색", System.currentTimeMillis(), key, this.sortedLinearSearch(sortList, key));
            case "비정렬 순차탐색":
                return new SearchResult("비정렬 순차 탐색", System.currentTimeMillis(), key, this.notSortedLinearSearch(key));
            case "이진탐색":
                return new SearchResult("이진 탐색", System.currentTimeMillis(), key, this.binarySearch(sortList, key));
            case "해시탐색":
                return new SearchResult("해시 탐색", System.currentTimeMillis(), key, this.hashSearch(key));
            default:
                throw new IllegalArgumentException();
        }
    }


    //hash method

    private int getEmptySpace(int num) {
        int idx = hash(num);
        int i = 0;
        while (this.hash[i] != 0) {
            idx++;
            i++;
            if (idx == this.size) {
                idx = 0;
            }
            if (i == this.size) {
                return -1;
            }
        }
        return idx;
    }

    private int hash(int num) {
        return num % size;
    }

    public boolean set(int num) {
        int idx = getEmptySpace(num);
        if (idx < 0) {
            return false;
        }
        hash[idx] = num;
        return true;
    }
}