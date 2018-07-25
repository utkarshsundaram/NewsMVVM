package newsapp.news_mvvm.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.Observer;

import newsapp.news_mvvm.R;
import newsapp.news_mvvm.adapter.NewsAdapter;
import newsapp.news_mvvm.databinding.ActivityNewsListBinding;
import newsapp.news_mvvm.viewmodel.NewsListViewModel;

public class NewsListActivity extends AppCompatActivity implements Observer {
ActivityNewsListBinding newsListBinding;
private NewsListViewModel mNewsListModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setupObserver(mNewsListModel);
        setupListPeopleView(newsListBinding.listNews);
    }

    private void setupListPeopleView(RecyclerView listNews)
    {
        NewsAdapter adapter = new NewsAdapter();
        listNews.setAdapter(adapter);
        listNews.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initDataBinding()
    {
        newsListBinding= DataBindingUtil.setContentView(this,R.layout.activity_news_list);
        mNewsListModel=new NewsListViewModel(this);
        newsListBinding.setMainViewModel(mNewsListModel);
    }
    public void setupObserver(java.util.Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(java.util.Observable observable, Object o) {
        if (observable instanceof NewsListViewModel)
        {
            NewsAdapter newsAdapter = (NewsAdapter) newsListBinding.listNews.getAdapter();
            NewsListViewModel peopleViewModel = (NewsListViewModel) observable;
            newsAdapter.setPeopleList(peopleViewModel.getNewsList());
        }
    }
}
