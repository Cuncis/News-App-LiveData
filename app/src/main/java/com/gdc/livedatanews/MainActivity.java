package com.gdc.livedatanews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.res.Configuration;
import android.os.Bundle;

import com.gdc.livedatanews.adapter.BlogAdapter;
import com.gdc.livedatanews.model.Blog;
import com.gdc.livedatanews.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefresh;
    private MainViewModel mainViewModel;

    private BlogAdapter blogAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        getPopularBlog();

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPopularBlog();
            }
        });
    }

    private void getPopularBlog() {
        swipeRefresh.setRefreshing(true);
        mainViewModel.getAllBlog().observe(this, new Observer<List<Blog>>() {
            @Override
            public void onChanged(List<Blog> blogs) {
                swipeRefresh.setRefreshing(false);
                initRecyclerView(blogs);
            }
        });
    }

    private void initRecyclerView(List<Blog> blogs) {
        blogAdapter = new BlogAdapter(blogs);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(blogAdapter);
        blogAdapter.notifyDataSetChanged();
    }

    private void initView() {
        swipeRefresh = findViewById(R.id.swipe_refresh);
        recyclerView = findViewById(R.id.blogRecyclerView);
    }
}
