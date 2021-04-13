package school_project.search_algorithm.search;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SearchResult {
    private String name;

    private int index;
    private int key;
    private String startTime;
    private double currentTimeMills;

    public SearchResult(String name, double currentTimeMills, int key, int index) {
        this.name = name;
        this.currentTimeMills = currentTimeMills;
        this.index = index;
        this.key = key;
        this.startTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public String getStartTime() {
        return startTime;
    }

    public double getElapsedTime() {
        return (System.currentTimeMillis() - currentTimeMills) / 1000;
    }

    @Override
    public String toString() {
        return "SearchResult { " +
                "\n검색 알고리즘 = '" + name + '\'' +
                "\n찾는 값 = '" + key + '\'' +
                "\n결과 값(인덱스) = '" + index + '\'' +
                "\n시작 시간 = " + startTime +
                "\n경과 시간 = " + this.getElapsedTime();
    }
}