package com.example.seeker;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

/*
 * A simple {@link Fragment} subclass.
 * Use the {@link MoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoreFragment extends Fragment {

    Button btnEdit;
    Button btnLogout;
    public static final String TAG = "MoreFragment";
    private RecyclerView rvMore;
    protected SocialAdapter adapter3;
    protected List<Social> allSocials;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_more, container, false);
        View view = inflater.inflate(R.layout.fragment_more, container, false);

        btnEdit = view.findViewById(R.id.btnEdit);
        btnLogout = view.findViewById(R.id.btnLogout);


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), EditActivity.class));
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseUser.logOutInBackground();
                startActivity(new Intent(getActivity(), LoginActivity.class));

            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMore = view.findViewById(R.id.rvMore);

        allSocials = new ArrayList<>();
        adapter3 = new SocialAdapter(getContext(), allSocials);
        //
        //
        rvMore.setAdapter(adapter3);
        //
        rvMore.setLayoutManager(new LinearLayoutManager(getContext()));
        querySocial();


    }

    protected void querySocial() {

        ParseQuery<Social> query = ParseQuery.getQuery(Social.class);
        query.include(Social.KEY_SOCIALUSER);
        query.setLimit(20);
        query.addDescendingOrder(Social.KEY_CREATED_KEY2);


        query.findInBackground(new FindCallback<Social>() {
            @Override
            public void done(List<Social> socials, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with getting posts", e);
                    return;
                }
                for (Social social : socials) {
                    Log.i(TAG, "Post: " + social.getCaption() + ", username" + social.getSocialUser().getUsername());
                }

                allSocials.addAll(socials);
                adapter3.notifyDataSetChanged();

            }
        });

    }
}