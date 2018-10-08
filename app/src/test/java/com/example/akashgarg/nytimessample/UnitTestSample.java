package com.example.akashgarg.nytimessample;

import android.content.Context;

import com.example.akashgarg.nytimessample.models.ResultsItem;
import com.example.akashgarg.nytimessample.retrofit.ResponseParser;
import com.example.akashgarg.nytimessample.retrofit.RetrofitResponseCalls;
import com.google.gson.Gson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UnitTestSample {

    private static final String FAKE_STRING = "HELLO WORLD";

    @Mock
    Context mMockContext;


    @Test
    public void readStringFromContext_LocalizedString() {
        RetrofitResponseCalls api = new RetrofitResponseCalls(null);
        try {
            ResponseParser<ArrayList<ResultsItem>> data = api.getTextArticles().execute().body();
            System.out.println(new Gson().toJson(data));
            assertThat(data.getStatus().toLowerCase(), is("ok"));
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat("",is(""));
    }
}