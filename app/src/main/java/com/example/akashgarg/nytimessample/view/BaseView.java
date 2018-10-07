package com.example.akashgarg.nytimessample.view;


public interface BaseView {
    void showLoading();
    void hideLoading();
    void destroy();
    void showToast(String message);
}
