package com.example.seeker;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;


@ParseClassName("Reviews")
public class Review extends ParseObject {

    public static final String KEY_REVIEW = "review";
    public static final String KEY_REVIEWPIC = "review_pic";
    public static final String KEY_REVIEWUSER = "review_user";
    public static final String KEY_RATING = "ratings";
    public static final String KEY_CREATED_KEY = "createdAt";

    public String getReview() {
        return getString(KEY_REVIEW);
    }

    public void setReview(String review){
        put(KEY_REVIEW, review);
    }

    public ParseFile getImage(){
        return getParseFile(KEY_REVIEWPIC);
    }

    public void setImage(ParseFile parseFile){
        put(KEY_REVIEWPIC, parseFile);
    }

    public ParseUser getReviewUser(){
        return getParseUser(KEY_REVIEWUSER);
    }

    public void setReviewUser(ParseUser reviewuser){
        put(KEY_REVIEWUSER, reviewuser);
    }

    public Number getRating() {
        return getNumber(KEY_RATING);
    }

    public void setRating(Number rating){
        put(KEY_RATING, rating);
    }
}
