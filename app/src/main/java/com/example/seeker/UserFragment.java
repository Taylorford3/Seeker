package com.example.seeker;

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

import com.example.seeker.R;
import com.example.seeker.User;
import com.example.seeker.UserAdapter;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {
    public static final String TAG = "UserFragment";
    private RecyclerView rvUsers;
    protected UserAdapter adapter;
    protected List<User> allUsers;

    public UserFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvUsers = view.findViewById(R.id.rvUsers);

        allUsers = new ArrayList<>();
        adapter = new UserAdapter(getContext(), allUsers);
        //
        //
        rvUsers.setAdapter(adapter);
        //
        rvUsers.setLayoutManager(new LinearLayoutManager(getContext()));
        queryUser();


    }

    protected void queryUser() {

        ParseQuery<User> query = ParseQuery.getQuery(User.class);
        query.include(User.KEY_USERNAME);
        query.setLimit(20);
        query.addDescendingOrder(User.KEY_CREATED_KEY);


        query.findInBackground(new FindCallback<User>() {
            @Override
            public void done(List<User> users, ParseException e) {
                if (e != null){
                    Log.e(TAG, "Issue with getting users");
                    return;
                }
                for (User user : users){
                    Log.i(TAG, "User: " + user.getUser().getUsername());
                }

                allUsers.addAll(users);
                adapter.notifyDataSetChanged();

            }
        });
    }



}