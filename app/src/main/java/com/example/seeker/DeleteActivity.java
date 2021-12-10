package com.example.seeker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.parse.ParseUser;

public class DeleteActivity extends AppCompatActivity {

    private RadioButton rbDelete;
    private Button btnDeleteUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        rbDelete = findViewById(R.id.rbDelete);
        btnDeleteUser = findViewById(R.id.btnDeleteUser);

        btnDeleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}