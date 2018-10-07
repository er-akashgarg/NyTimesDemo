package com.example.akashgarg.nytimessample.view;

import com.example.akashgarg.nytimessample.models.ResultsItem;

import java.util.ArrayList;

public interface ArticleView extends BaseView{
    void showData(ArrayList<ResultsItem> articles);
    void noData();
}
