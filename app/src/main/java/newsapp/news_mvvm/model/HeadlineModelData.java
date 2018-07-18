package newsapp.news_mvvm.model;

import java.util.ArrayList;

/**
 * Created by user on 5/6/17.
 */

public class HeadlineModelData {
    private String status;
    private String source;
    private String sortBy;
    private ArrayList<ArticlesModelData> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public ArrayList<ArticlesModelData> getAriticles() {
        return articles;
    }

    public void setAriticles(ArrayList<ArticlesModelData> ariticles) {
        this.articles = articles;
    }

}
