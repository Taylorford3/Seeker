package com.example.seeker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.parse.ParseUser;


public class EditActivity extends AppCompatActivity {

    EditText etName;
    String name;
    ParseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
       // ParseUser user = ParseUser.getCurrentUser();
        final ParseUser parseUser = ParseUser.getCurrentUser();

        if (parseUser.get("profileName") == null) {
            etName.setText("");

        } else {
            etName.setText(parseUser.get("profileName").toString());

        }
/*
        btnUpdateInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseUser.put("profileName", edtProfileName.getText().toString());
*/

       // ParseUser currentUser = ParseUser.getCurrentUser();
       // etName=findViewById(R.id.etName);


    }

}