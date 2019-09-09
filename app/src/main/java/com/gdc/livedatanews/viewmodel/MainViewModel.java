package com.gdc.livedatanews.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.gdc.livedatanews.data.BlogRepository;
import com.gdc.livedatanews.model.Blog;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private BlogRepository blogRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        blogRepository = new BlogRepository(application);
    }

    public LiveData<List<Blog>> getAllBlog() {
        return blogRepository.getMutableLiveData();
    }
}
