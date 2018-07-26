package newsapp.news_mvvm.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import newsapp.news_mvvm.R;
import newsapp.news_mvvm.databinding.ActivityNewsDetailsBinding;
import newsapp.news_mvvm.viewmodel.NewsDetailsLinkViewModel;


import static newsapp.news_mvvm.utils.Constants.EXTRA_NEWS;

public class NewsDetailsActivity extends AppCompatActivity {
    public ActivityNewsDetailsBinding binding;

    public static Intent launchDetail(Context context, String url) {
        Intent intent = new Intent(context, NewsDetailsActivity.class);
        intent.putExtra(EXTRA_NEWS, url);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }

    private void initViews() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news_details);
        binding.setUrl(getIntent().getStringExtra(EXTRA_NEWS));
        binding.setNewsViewModel(new NewsDetailsLinkViewModel());
    }
}
