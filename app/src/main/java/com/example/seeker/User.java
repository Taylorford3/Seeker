package com.example.seeker;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("User")
public class User extends ParseObject {


    public static final String KEY_PROFILEPIC = "profile";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_BUSINESS2 = "bus_name";


    public String getUsername() {
        return getString(KEY_USERNAME);
    }

    public void setUsername(String username){
        put(KEY_USERNAME, username);
    }

    public ParseFile getProfilePic(){
        return getParseFile(KEY_PROFILEPIC);
    }

    public void setProfilePic(ParseFile parseFile){
        put(KEY_PROFILEPIC, parseFile);
    }

    //public ParseUser getUser(){
      //  return getParseUser(KEY_USER);
   // }

   // public void setUser(ParseUser user){
    //    put(KEY_USER, user);
   // }

    public String getBusiness2() {
        return getString(KEY_BUSINESS2);
    }

    public void setBusiness2(String business2){
        put(KEY_BUSINESS2, business2);
    }
}

