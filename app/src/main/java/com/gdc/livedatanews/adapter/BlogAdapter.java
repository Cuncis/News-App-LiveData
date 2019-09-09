package com.gdc.livedatanews.adapter;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gdc.livedatanews.R;
import com.gdc.livedatanews.model.Blog;

import java.util.List;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.BlogHolder> {

    private List<Blog> blogList;

    public BlogAdapter(List<Blog> blogList) {
        this.blogList = blogList;
    }

    @NonNull
    @Override
    public BlogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_blog, parent, false);
        return new BlogHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return blogList.size();
    }

    class BlogHolder extends BaseViewHolder {

        ImageView imgThumbnail;
        TextView tvTitle, tvDescription, tvLink;

        public BlogHolder(@NonNull View itemView) {
            super(itemView);
            imgThumbnail = itemView.findViewById(R.id.ivThumbnail);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvLink = itemView.findViewById(R.id.tvLink);
        }

        @Override
        protected void clear() {
            imgThumbnail.setImageDrawable(null);
            tvTitle.setText("");
            tvLink.setText("");
            tvDescription.setText("");
        }

        public void onBind(int position) {
            final Blog blog = blogList.get(position);
            if (blog.getThumbnail() != null) {
                Glide.with(itemView.getContext())
                        .load(blog.getThumbnail())
                        .into(imgThumbnail);
            }

            if (blog.getTitle() != null) {
                tvTitle.setText(blog.getTitle());
            }

            if (blog.getLink() != null) {
                tvLink.setText(blog.getLink());
            }

            if (blog.getDescription() != null) {
                tvDescription.setText(blog.getDescription());
            }

            tvLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (blog.getLink() != null) {
                        try {
                            Intent i = new Intent();
                            i.setAction(Intent.ACTION_VIEW);
                            i.addCategory(Intent.CATEGORY_BROWSABLE);
                            i.setData(Uri.parse(blog.getLink()));
                            itemView.getContext().startActivity(i);
                        } catch (Exception e) {
                            Log.e("_logError", "ImageURL Not Correct: Error -> " + e.getMessage() );
                        }
                    }
                }
            });
        }
    }

}




























