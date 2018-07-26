package newsapp.news_mvvm.viewmodel;

import android.content.Context;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import newsapp.news_mvvm.model.ArticlesModelData;
import newsapp.news_mvvm.model.HeadlineModelData;
import newsapp.news_mvvm.network.ApiClient;
import newsapp.news_mvvm.network.NetworkInteface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * Created by user on 18/7/18.
 */

public class NewsListViewModel extends Observable
{
    public ObservableInt peopleProgress;
    public Context mContext;
    public ObservableInt peopleRecycler;
    private List<ArticlesModelData> newsList;

    public NewsListViewModel(@NonNull Context context) {
        mContext = context;
        this.newsList = new ArrayList<>();
        peopleProgress = new ObservableInt(View.VISIBLE);
        peopleRecycler = new ObservableInt(View.GONE);
        initData();

    }

    private void initData()
    {
        NetworkInteface apiService =
                ApiClient.getClient().create(NetworkInteface.class);
        Call<HeadlineModelData> call=apiService.newsList();
        call.enqueue(new Callback<HeadlineModelData>() {
            @Override
            public void onResponse(Call<HeadlineModelData> call, Response<HeadlineModelData> response) {
               if(response.isSuccessful()){
                   peopleProgress.set(View.GONE);
                   peopleRecycler.set(View.VISIBLE);
                   if(response.body().getAriticles()!=null){
                       changeNewsDataSet(response.body().getAriticles());
                   }

               }else{
                   Toast.makeText(mContext,"there is a problem with this request please comeback",Toast.LENGTH_LONG).show();
               }

            }
            @Override
            public void onFailure(Call<HeadlineModelData> call, Throwable t) {
                peopleProgress.set(View.GONE);
                Toast.makeText(mContext,"No internet",Toast.LENGTH_LONG).show();
                peopleRecycler.set(View.GONE);
            }
        });
    }
    private void changeNewsDataSet(List<ArticlesModelData> peoples) {
        newsList.addAll(peoples);
        setChanged();
        notifyObservers();
    }
    public List<ArticlesModelData> getNewsList() {
        return newsList;
    }
}
