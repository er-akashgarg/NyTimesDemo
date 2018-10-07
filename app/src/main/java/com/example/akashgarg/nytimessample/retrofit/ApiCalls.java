package com.example.akashgarg.nytimessample.retrofit;

import com.example.akashgarg.nytimessample.models.ResultsItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCalls {

    @GET("http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=41621ea8e03949a9bb507ebad2b8c209")
    Call<ResponseParser<ArrayList<ResultsItem>>> getArticlesList();

}
