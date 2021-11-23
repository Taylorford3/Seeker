package com.example.seeker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.seeker.R;
import com.parse.ParseException;
import com.parse.SaveCallback;

public class ReviewActivity extends AppCompatActivity {

    TextView tvBusinessName;
    RatingBar ratingBar;
    RecyclerView rvReviews;
    TextView tvDescription2;
    ImageView ivBusinessPic;
    Button btnClaim;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);


        tvBusinessName = findViewById(R.id.tvBusinessName);
        tvDescription2 = findViewById(R.id.tvDescription2);
        ivBusinessPic = findViewById(R.id.ivBusinessPic);
        btnClaim = findViewById(R.id.btnClaim);
        ratingBar = findViewById(R.id.ratingBar);

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