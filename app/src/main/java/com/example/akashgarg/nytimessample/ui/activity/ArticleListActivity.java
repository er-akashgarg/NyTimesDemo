package com.example.akashgarg.nytimessample.ui.activity;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;

import com.example.akashgarg.nytimessample.R;
import com.example.akashgarg.nytimessample.models.ResultsItem;
import com.example.akashgarg.nytimessample.presenter.ArticleListPresenter;
import com.example.akashgarg.nytimessample.ui.adapter.ArticlesListAdapter;
import com.example.akashgarg.nytimessample.view.ArticleView;

import java.util.ArrayList;

import butterknife.BindView;


public class ArticleListActivity extends BaseActivity<ArticleListPresenter> implements ArticleView {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private ArticlesListAdapter adapter = null;

    @Override
    public int getViewLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onLayoutAddedToView() {
        initNavigation();
        init();
        getmPresentor().getData();
    }

    @Override
    public ArticleListPresenter getPresentor() {
        return new ArticleListPresenter();
    }

    private void init() {
        adapter = new ArticlesListAdapter(this);
        recyclerView.setLayoutManager(getLayoutManager(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void destroy() {
        adapter.destroyResource();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void showData(ArrayList<ResultsItem> articles) {
        adapter.updateList(articles);
    }

    @Override
    public void noData() {
        showToast("Unable to fetch data !");
    }

    private void initNavigation() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
