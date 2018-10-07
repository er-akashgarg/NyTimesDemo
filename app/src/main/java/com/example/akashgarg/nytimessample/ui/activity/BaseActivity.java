package com.example.akashgarg.nytimessample.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.akashgarg.nytimessample.presenter.BasePresentor;

import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressWarnings("ALL")
abstract class BaseActivity<P extends BasePresentor> extends AppCompatActivity {

    private P mPresentor;

    private Toast toast = null;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewLayout());
        unbinder = ButterKnife.bind(this);
        mPresentor = getPresentor();
        if (mPresentor != null)
            mPresentor.onAttach(this);

        onLayoutAddedToView();
    }

    public LinearLayoutManager getLayoutManager(Activity mActivity, int orientation) {
        return new LinearLayoutManager(mActivity, orientation, false);
    }

    public void showToast(String msg) {
        if (null != toast) {
            toast = null;
        }
        toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onDestroy() {
        if (mPresentor != null)
            mPresentor.onDetach();
        mPresentor = null;
        unbinder.unbind();
        super.onDestroy();
    }

    abstract public int getViewLayout();

    abstract public void onLayoutAddedToView();

    abstract public P getPresentor();

    public P getmPresentor() {
        return mPresentor;
    }


}
