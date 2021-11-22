package com.example.seeker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.seeker.R;

public class ReviewActivity extends AppCompatActivity {

    TextView tvBusinessName;
    RatingBar ratingBar;
    RecyclerView rvReviews;
    ImageView ivBusinessPic;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);


        tvBusinessName = findViewById(R.id.tvBusinessName);
        ivBusinessPic = findViewById(R.id.ivBusinessPic);
        ratingBar = findViewById(R.id.ratingBar);

        String business = getIntent().getStringExtra("bus_name");
        tvBusinessName.setText(business);
    }

}