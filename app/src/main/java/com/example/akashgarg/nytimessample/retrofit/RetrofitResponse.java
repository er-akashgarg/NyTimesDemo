package com.example.akashgarg.nytimessample.retrofit;

public interface RetrofitResponse<T> {
    void requestSuccess(T data );
    void requestFailure(String data);
}
