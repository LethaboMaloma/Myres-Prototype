package com.example.myres;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {
    private List<Review> reviewList;

    public ReviewAdapter(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Review review = reviewList.get(position);
        holder.houseTitleTextView.setText(review.getHouseTitle());
        holder.reviewTextView.setText(review.getReviewText());
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView houseTitleTextView;
        TextView reviewTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            houseTitleTextView = itemView.findViewById(R.id.review_house_title);
            reviewTextView = itemView.findViewById(R.id.review_text);
        }
    }
}

