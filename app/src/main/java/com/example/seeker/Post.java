package com.example.seeker;

import com.parse.ParseClassName;
import com.parse.ParseFile;


import com.parse.ParseObject;
import com.parse.ParseUser;


@ParseClassName("Business")
public class Post extends ParseObject {

    public static final String KEY_DESCRIPTION = "category_id";
    public static final String KEY_IMAGE = "bus_pic";
    public static final String KEY_USER = "user";
    public static final String KEY_CREATED_KEY = "createdAt";


    public String getDescription() {
        return getString(KEY_DESCRIPTION);
    }

    public void setDescription(String category_id){
        put(KEY_DESCRIPTION, category_id);
    }

    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }

    public void setImage(ParseFile parseFile){
        put(KEY_IMAGE, parseFile);
    }

    public ParseUser getUser(){
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser bus_name){
        put(KEY_USER, bus_name);
    }
}

