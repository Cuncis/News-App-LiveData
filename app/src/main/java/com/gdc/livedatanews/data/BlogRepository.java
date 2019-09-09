package com.gdc.livedatanews.data;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.gdc.livedatanews.model.Blog;
import com.gdc.livedatanews.model.BlogResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlogRepository {
    private ArrayList<Blog> movies = new ArrayList<>();
    private MutableLiveData<List<Blog>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public BlogRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Blog>> getMutableLiveData() {
        BlogApiService apiService = ApiClient.getBlogApiService();
        Call<BlogResponse> call = apiService.getPopularBlog();
        call.enqueue(new Callback<BlogResponse>() {
            @Override
            public void onResponse(Call<BlogResponse> call, Response<BlogResponse> response) {
                BlogResponse body = response.body();
                if (body != null && body.getData() != null) {
                    movies = (ArrayList<Blog>) body.getData();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<BlogResponse> call, Throwable t) {
                Toast.makeText(application, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return mutableLiveData;
    }
}
















