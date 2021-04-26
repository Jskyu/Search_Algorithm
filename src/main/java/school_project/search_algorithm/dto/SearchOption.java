package school_project.search_algorithm.dto;

public class SearchOption {
    private String opt;
    private int key;

    public SearchOption(String opt, int key) {
        this.opt = opt;
        this.key = key;
    }

    public SearchOption() {
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "SearchOption{" +
                "opt='" + opt + '\'' +
                ", key=" + key +
                '}';
    }
}
