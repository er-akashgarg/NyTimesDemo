package com.example.akashgarg.nytimessample.presenter;

import com.example.akashgarg.nytimessample.retrofit.ResponseParser;
import com.example.akashgarg.nytimessample.models.ResultsItem;
import com.example.akashgarg.nytimessample.view.ArticleView;
import com.example.akashgarg.nytimessample.retrofit.RetrofitResponse;
import com.example.akashgarg.nytimessample.retrofit.RetrofitResponseCalls;

import java.util.ArrayList;

public class ArticleListPresenter extends BasePresentor<ArticleView> implements RetrofitResponse<ResponseParser<ArrayList<ResultsItem>>> {

    public void getData() {
        if(getmView()!=null)
        getmView().showLoading();
        RetrofitResponseCalls call = new RetrofitResponseCalls(this);
        call.getArticles();
    }

    @Override
    public void requestSuccess(ResponseParser<ArrayList<ResultsItem>> response) {
        if (null != getmView()) {
            getmView().hideLoading();
            if (response != null && response.getStatus().equalsIgnoreCase("OK")) {
                getmView().showData(response.getResults());
            } else
                getmView().noData();
        }
    }

    @Override
    public void requestFailure(String response) {
        if (null != getmView()) {
            getmView().hideLoading();
            getmView().showToast(response);
            getmView().noData();
        }
    }
}
