package school_project.search_algorithm.service;

import school_project.search_algorithm.dto.IndexResult;
import school_project.search_algorithm.dto.SearchOption;
import school_project.search_algorithm.dto.SearchResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SearchService {

    private final int SIZE = 100000;
    private final int NOT_FOUND_CODE = -1;

    private final List<Integer> list = new ArrayList<>();
    private final List<Integer> sortList;
    private final int[] hash = new int[SIZE];
    private final List<SearchResult> resultList = new ArrayList<>();

    public SearchService() {
        //1~100000의 숫자를 겹치지 않고 랜덤하게 list에 입력
        setNotSortedList();

        //정렬 리스트 입력
        sortList = list.stream().sorted().collect(Collectors.toList());

        //1~10000의 숫자를 해시 탐색법으로 입력
        for (int i = 1; i <= SIZE; i++) {
            this.set(i);
        }
    }

    public void unOrderedListReset(){
        this.list.clear();
        this.setNotSortedList();
    }

    public List<SearchResult> getResult() {
        return this.resultList;
    }

    public int notSortedLinearSearch(int key) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key) return i;
        }
        return NOT_FOUND_CODE;
    }

    public int sortedLinearSearch(List<Integer> list, int key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key)
                return i;
            else if (list.get(i) > key) return NOT_FOUND_CODE;
        }
        return NOT_FOUND_CODE;
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
        return NOT_FOUND_CODE;
    }

    public int hashSearch(int key) {
        int index = key % SIZE;

        if (this.hash[index] != key) {
            index++;
            int i = 0;
            while (this.hash[index] != key) {
                index++;
                i++;
                if (index == this.SIZE) {
                    index = 0;
                }
                if (i == this.SIZE) {
                    return NOT_FOUND_CODE;
                }
            }
        }
        return index;
    }

    public List<SearchResult> result(SearchOption searchOpt) {
        String opt = searchOpt.getOpt();
        int key = searchOpt.getKey();
        double startTime = System.currentTimeMillis();
        switch (opt) {
            case "정렬 순차탐색":
                resultList.add(new SearchResult("정렬 순차 탐색", key, this.sortedLinearSearch(sortList, key)));
                break;
            case "비정렬 순차탐색":
                resultList.add(new SearchResult("비정렬 순차 탐색", key, this.notSortedLinearSearch(key)));
                break;
            case "이진탐색":
                resultList.add(new SearchResult("이진 탐색", key, this.binarySearch(sortList, key)));
                break;
            case "해시탐색":
                resultList.add(new SearchResult("해시 탐색", key, this.hashSearch(key)));
                break;
            default:
                throw new IllegalArgumentException("잘못된 접근");
        }
        resultList.get(resultList.size()-1).setElapsedTime((System.currentTimeMillis() - startTime) / 1000);
        return resultList;
    }

    public IndexResult findIndex(SearchOption searchOpt){
        IndexResult array;

        String opt = searchOpt.getOpt();
        int key = searchOpt.getKey();
        switch (opt) {
            case "순차정렬":
                array = new IndexResult(key, sortList.get(key));
                break;
            case "비정렬":
                array = new IndexResult(key, list.get(key));
                break;
            case "해싱":
                array = new IndexResult(key, hash[key]);
                break;
            default:
                throw new IllegalArgumentException("잘못된 접근");
        }
        return array;
    }

    private void setNotSortedList() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= SIZE; i++) {
            stack.add(i);
        }
        while (stack.size() > 0) {
            int rand = (int) (Math.random() * stack.size());
            list.add(stack.remove(rand));
        }
    }


    //hash method
    private int getEmptySpace(int num) {
        int idx = num % SIZE;
        int i = 0;
        while (this.hash[i] != 0) {
            idx++;
            i++;
            if (idx == this.SIZE) {
                idx = 0;
            }
            if (i == this.SIZE) {
                return NOT_FOUND_CODE;
            }
        }
        return idx;
    }

    private void set(int num) {
        int idx = getEmptySpace(num);
        if (idx < 0) {
            return;
        }
        hash[idx] = num;
    }
}