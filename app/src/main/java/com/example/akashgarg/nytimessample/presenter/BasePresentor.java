package com.example.akashgarg.nytimessample.presenter;

public class BasePresentor<V> {

    private V mView;

    public void onAttach(V mView) {
        this.mView = mView;
    }

    public void onDetach() {
        mView = null;
    }


    V getmView() {
        return mView;
    }
}
