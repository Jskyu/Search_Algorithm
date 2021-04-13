package school_project.search_algorithm.search;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SearchResult {
    private String name;

    private int index;
    private int key;
    private String startDateTime;
    private double startTime;
    private double elapsedTime;

    public SearchResult(String name, int key, int index) {
        this.name = name;
        this.index = index;
        this.key = key;
        this.startDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        this.startTime = System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public double getElapsedTime() {
        return elapsedTime;
    }

    public int getKey() {
        return key;
    }

    public void setElapsedTime(double elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    @Override
    public String toString() {
        return "SearchResult { " +
                "\n검색 알고리즘 = '" + name + '\'' +
                "\n찾는 값 = '" + key + '\'' +
                "\n결과 값(인덱스) = '" + index + '\'' +
                "\n시작 시간 = " + startDateTime +
                "\n경과 시간 = " + this.getElapsedTime();
    }
}