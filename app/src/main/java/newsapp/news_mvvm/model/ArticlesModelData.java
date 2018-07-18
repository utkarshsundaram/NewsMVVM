package newsapp.news_mvvm.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 5/6/17.
 */

public class ArticlesModelData implements Parcelable {
    private String author;
    public String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    public static final Creator<ArticlesModelData> CREATOR = new Creator<ArticlesModelData>() {
        @Override
        public ArticlesModelData createFromParcel(Parcel in) {
            return new ArticlesModelData(in);
        }

        @Override
        public ArticlesModelData[] newArray(int size) {
            return new ArticlesModelData[size];
        }
    };


    private ArticlesModelData(Parcel in) {
        author = in.readString();
        title = in.readString();
        description = in.readString();
        url = in.readString();
        urlToImage = in.readString();
        publishedAt = in.readString();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(author);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(url);
        dest.writeString(urlToImage);
        dest.writeString(publishedAt);
    }
}
