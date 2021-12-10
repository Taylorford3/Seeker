package com.example.seeker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.seeker.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

public class ReviewActivity extends AppCompatActivity {

    public static final String TAG = "Reviewactivity";
    TextView tvBusinessName;
    RatingBar ratingBar;
    TextView tvDescription2;
    ImageView ivBusinessPic;
    Button btnClaim;
    List<Review> reviews;
    RecyclerView rvReviews;
    ReviewAdapter adapter;

    EndlessRecyclerViewScrollListener scrollListener;
    //protected List<Review> allReviews;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);


        tvBusinessName = findViewById(R.id.tvBusinessName);
        tvDescription2 = findViewById(R.id.tvDescription2);
        ivBusinessPic = findViewById(R.id.ivBusinessPic);
        btnClaim = findViewById(R.id.btnClaim);
        ratingBar = findViewById(R.id.ratingBar);
        rvReviews = findViewById(R.id.rvReviews);

        reviews = new ArrayList<>();
        adapter = new ReviewAdapter(this, reviews);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvReviews.setLayoutManager(layoutManager);
        rvReviews.setAdapter(adapter);


        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                Log.i(TAG, "onLoadMore" + page);
                //loadMoreData();
            }
        };

        rvReviews.addOnScrollListener(scrollListener);

        //populateHomeTimeline();

        String business = getIntent().getStringExtra("bus_name");
        tvBusinessName.setText(business);
        String description = getIntent().getStringExtra("category_id");
        tvDescription2.setText(description);




        btnClaim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ParseUser user = new ParseUser();
                // Set custom properties

                final Intent i = new Intent(ReviewActivity.this, RegisterActivity.class);
                startActivity(i);
                finish();

            }
        });







    }



}