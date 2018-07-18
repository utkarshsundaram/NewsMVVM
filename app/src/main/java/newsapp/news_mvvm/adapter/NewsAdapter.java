package newsapp.news_mvvm.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import newsapp.news_mvvm.R;
import newsapp.news_mvvm.databinding.RecyclerNewsHeadlinesBinding;
import newsapp.news_mvvm.model.ArticlesModelData;
import newsapp.news_mvvm.model.HeadlineModelData;
import newsapp.news_mvvm.viewmodel.NewsDetailViewModel;

/**
 * Created by user on 18/7/18.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsAdapterViewHolder> {

    private List<ArticlesModelData> headlineList;

    public NewsAdapter() {
        this.headlineList = Collections.emptyList();
    }
    @NonNull
    @Override
    public NewsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerNewsHeadlinesBinding itemPeopleBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recycler_news_headlines,
                        parent, false);
        return new NewsAdapterViewHolder(itemPeopleBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapterViewHolder holder, int position) {
       holder.bindHeadline(headlineList.get(position));
    }

    @Override
    public int getItemCount() {
        return headlineList.size();
    }
    public void setPeopleList(List<ArticlesModelData> headlineList) {
        this.headlineList = headlineList;
        notifyDataSetChanged();
    }
    public static class NewsAdapterViewHolder extends RecyclerView.ViewHolder {
        RecyclerNewsHeadlinesBinding mItemPeopleBinding;

        public NewsAdapterViewHolder(RecyclerNewsHeadlinesBinding itemPeopleBinding) {
            super(itemPeopleBinding.cardView);
            this.mItemPeopleBinding = itemPeopleBinding;
        }

        void bindHeadline(ArticlesModelData articlesModelData) {
            if (mItemPeopleBinding.getPeopleViewModel() == null) {
                mItemPeopleBinding.setPeopleViewModel(
                        new NewsDetailViewModel(articlesModelData, itemView.getContext()));
            } else {
                mItemPeopleBinding.getPeopleViewModel().setHeadline(articlesModelData);
            }
        }
    }
}
