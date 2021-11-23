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

import java.util.ArrayList;
import java.util.List;

/*
 * A simple {@link Fragment} subclass.
 * Use the {@link MoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoreFragment extends Fragment {

    Button btnEdit;
    public static final String TAG = "MoreFragment";
    private RecyclerView rvMore;
    protected PostsAdapter adapter;
    protected List<Post> allPosts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_more, container, false);
        View view = inflater.inflate(R.layout.fragment_more, container, false);

        btnEdit = view.findViewById(R.id.btnEdit);


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), EditActivity.class));
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMore = view.findViewById(R.id.rvMore);

        allPosts = new ArrayList<>();
        adapter = new PostsAdapter(getContext(), allPosts);
        //
        //
        rvMore.setAdapter(adapter);
        //
        rvMore.setLayoutManager(new LinearLayoutManager(getContext()));
        queryPost();


    }

    protected void queryPost() {

        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
        query.include(Post.KEY_USER);
        query.setLimit(20);
        query.addDescendingOrder(Post.KEY_CREATED_KEY);


        query.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with getting posts");
                    return;
                }
                for (Post post : posts) {
                    Log.i(TAG, "Post: " + post.getDescription() + ", username" + post.getUser().getUsername() + post.getBusiness());
                }

                allPosts.addAll(posts);
                adapter.notifyDataSetChanged();

            }
        });

    }
}