package newsapp.news_mvvm.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableInt;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by user on 26/7/18.
 */

public class NewsDetailsLinkViewModel extends BaseObservable {
    public static ObservableInt newsProgress;

    public NewsDetailsLinkViewModel() {
        newsProgress = new ObservableInt(View.VISIBLE);
    }

    @BindingAdapter("loadurl")
    public static void loadurl(WebView mWebview, String url) {
        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

        mWebview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                newsProgress.set(View.GONE);

            }

            public void onPageFinished(WebView view, String url) {
                newsProgress.set(View.GONE);
            }
        });
        mWebview.loadUrl(url);
    }
}
