package school_project.search_algorithm.search;

public class IndexResult {
    private int index;
    private int value;

    public IndexResult(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public IndexResult() {
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }
}