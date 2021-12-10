package com.example.seeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class RegisterActivity extends AppCompatActivity {

    public static final String TAG = "RegisterActivity";
    private EditText etEmail;
    private EditText etPassword;
    private EditText etPhone;
    private EditText etName;
    private EditText etUsername;
    private Button btnSignup;
    private RadioButton rbBusinessUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etName);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        rbBusinessUser = findViewById(R.id.rbBusinessUser);
        btnSignup = findViewById(R.id.btnSignup);
        //rbBusinessUser = findViewById(R.id.rbBusinessUser);
/*
        rbBusinessUser.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (rbBusinessUser.isChecked()) {ParseUser user = new ParseUser();
                    user.put("bus_name", true);
                    user.saveInBackground(); // if you want to save immediately

                }
            }
        });*/


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser user = new ParseUser();
                // Set core properties
                user.setUsername(etUsername.getText().toString());
                user.setPassword(etPassword.getText().toString());
                user.setEmail(etEmail.getText().toString());


                // Set custom properties
                user.put("phone", etPhone.getText().toString());
                user.put("name",   etName.getText().toString());
                user.put("bus_user", rbBusinessUser.isChecked());


                // Invoke signUpInBackground
                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            final Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Sign up failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
