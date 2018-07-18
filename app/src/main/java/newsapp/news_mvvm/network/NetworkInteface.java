package newsapp.news_mvvm.network;
import newsapp.news_mvvm.model.HeadlineModelData;
import retrofit2.Call;
import retrofit2.http.GET;

import static newsapp.news_mvvm.network.NetworkApi.NEWSLIST;

/**
 * Created by user on 10/4/18.
 */

public interface NetworkInteface
{
    @GET(NEWSLIST)
    Call<HeadlineModelData> newsList();

}
