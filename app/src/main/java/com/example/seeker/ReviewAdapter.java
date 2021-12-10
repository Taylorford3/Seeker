package com.example.seeker;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    private Context context;
    private List<Review> reviews;

    public ReviewAdapter(Context context, List<Review> reviews) {
        this.context = context;
        this.reviews = reviews;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_review, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Review review = reviews.get(position);
        holder.bind(review);

    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }
    public void clear() {
        reviews.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Review> list) {
        reviews.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private ImageView ivReviewPic;
        private TextView tvReviewUser;
        private RatingBar ReviewRatingBar;
        private TextView tvReview;
        LinearLayout container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvReviewUser = itemView.findViewById(R.id.tvReviewUser);
            ivReviewPic = itemView.findViewById(R.id.ivReviewPic);
            tvReview = itemView.findViewById(R.id.tvReview);
            container = itemView.findViewById(R.id.container);
        }

        public void bind(Review review) {

            tvReview.setText(review.getReview());
            tvReviewUser.setText(review.getReviewUser().getUsername());
            //tvBusiness.setText(review.getBusiness());
            ParseFile image = review.getImage();
            if (image != null) {
                Glide.with(context).load(review.getImage().getUrl()).into(ivReviewPic);

            }


        }
    }



}
