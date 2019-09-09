package com.gdc.livedatanews.data;

import com.gdc.livedatanews.model.BlogResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BlogApiService {

    @GET("feed.json")
    Call<BlogResponse> getPopularBlog();

}
