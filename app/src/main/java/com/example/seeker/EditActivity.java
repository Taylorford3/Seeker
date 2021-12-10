package com.example.seeker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;


public class EditActivity extends AppCompatActivity {

    public static final String TAG = "EditActivity";
    EditText et_name;
    EditText et_email;
    EditText et_phone;
    Button btnUpdate;
    Button btnDeactivate;
    //String name;
    //ParseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        final ParseUser parseUser = ParseUser.getCurrentUser();
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_phone = findViewById(R.id.et_phone);
        btnUpdate= findViewById(R.id.btnUpdate);
        btnDeactivate= findViewById(R.id.btnDeactivate);

        //View view =  inflater.inflate(R.layout.activity_edit, container, false);
        //NavigationView navigationView = (NavigationView) findViewById(R.id.activity_view);

        if (parseUser.get("name") == null) {
            et_name.setText("");

        }
        else {
            et_name.setText(parseUser.get("name").toString());

        }

        if (parseUser.get("email") == null) {
            et_email.setText("");

        }
        else {
            et_email.setText(parseUser.get("email").toString());

        }
        if (parseUser.get("phone") == null) {
            et_phone.setText("");

        }
        else {
            et_phone.setText(parseUser.get("phone").toString());

        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ParseUser user = new ParseUser();
                // Set custom properties

                //ParseUser.getCurrentUser().put("name", et_name.getText().toString());
                parseUser.put("name", et_name.getText().toString());
                parseUser.put("email", et_email.getText().toString());
                parseUser.put("phone", et_phone.getText().toString());


                parseUser.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {

                    }



                });


            }
        });

        btnDeactivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseUser.getCurrentUser().deleteInBackground();
                ParseUser.logOutInBackground();
                final Intent i = new Intent(EditActivity.this, LoginActivity.class);
                startActivity(i);
                finish();

            }
        });



    }


}