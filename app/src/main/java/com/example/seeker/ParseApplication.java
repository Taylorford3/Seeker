package com.example.seeker;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("0FwtS9o9HXjjfEokALrwFSahSL3QV3ZgBdCJnTjq")
                .clientKey("rQM8fsVw02MxB8WyB6xnuorMniApMxzyrcQlFqlQ")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
