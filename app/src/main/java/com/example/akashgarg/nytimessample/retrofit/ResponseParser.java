package com.example.akashgarg.nytimessample.retrofit;

import com.google.gson.annotations.SerializedName;

public class ResponseParser<T>{

	@SerializedName("copyright")
	private String copyright;

	@SerializedName("results")
	private T results;

	@SerializedName("num_results")
	private int numResults;

	@SerializedName("status")
	private String status;

	public String getCopyright() {
		return copyright;
	}

	public T getResults() {
		return results;
	}

	public int getNumResults() {
		return numResults;
	}

	public String getStatus() {
		return status;
	}
}