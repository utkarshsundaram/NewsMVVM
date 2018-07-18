package newsapp.news_mvvm.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Observable;

import newsapp.news_mvvm.model.ArticlesModelData;
import newsapp.news_mvvm.model.HeadlineModelData;

/**
 * Created by user on 18/7/18.
 */

public class NewsDetailViewModel extends BaseObservable
{
    private ArticlesModelData data;
    private Context mContext;

    public NewsDetailViewModel(ArticlesModelData data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }
    public void setHeadline(ArticlesModelData data) {
        this.data = data;
        notifyChange();
    }
    public String getTitle() {
       return data.getTitle();
    }
    public String getDescription(){
        return data.getDescription();
    }

}
