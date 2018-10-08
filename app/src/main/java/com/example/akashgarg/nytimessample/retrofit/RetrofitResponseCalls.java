package com.example.akashgarg.nytimessample.retrofit;

import com.example.akashgarg.nytimessample.models.ResultsItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressWarnings("ALL")
public class RetrofitResponseCalls implements Callback {

    private RetrofitResponse listener;

    public RetrofitResponseCalls(RetrofitResponse listener) {
        this.listener = listener;
    }

    @Override
    public void onResponse(Call call, Response response) {
        if (null != listener) {
            if (response != null && response.code() == 200 && response.body() != null) {
                listener.requestSuccess(response.body());
            } else
                listener.requestFailure("Forbidden or Unreachable at this moment");
        }
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        if (null != listener)
            listener.requestFailure(t.getMessage());
    }


    public void getArticles() {
        Call<ResponseParser<ArrayList<ResultsItem>>> call = RestClient.getApi().getArticlesList();
        call.enqueue(this);
    }

    public Call<ResponseParser<ArrayList<ResultsItem>>> getTextArticles() {
        return RestClient.getApi().getTestArticle();
    }
}
