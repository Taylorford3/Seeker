package com.example.seeker;

import com.parse.ParseClassName;
import com.parse.ParseFile;


import com.parse.ParseObject;
import com.parse.ParseUser;


@ParseClassName("Social")
public class Social extends ParseObject {

    public static final String KEY_Caption = "caption";
    public static final String KEY_PHOTO = "photo";
    public static final String KEY_SOCIALUSER = "user";
    public static final String KEY_CREATED_KEY2 = "createdAt";


    public String getCaption() {
        return getString(KEY_Caption);
    }

    public void setCaption(String caption){
        put(KEY_Caption, caption);
    }

    public ParseFile getPhoto(){
        return getParseFile(KEY_PHOTO);
    }

    public void setPhoto(ParseFile parseFile){
        put(KEY_PHOTO, parseFile);
    }

    public ParseUser getSocialUser(){
        return getParseUser(KEY_SOCIALUSER);
    }

    public void setSocialUser(ParseUser user){
        put(KEY_SOCIALUSER, user);
    }

}

