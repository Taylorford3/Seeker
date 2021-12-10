package com.example.seeker;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {
    public static final String TAG = "UserFragment";
    private static final String KEY_NAME = "name";
    private RecyclerView rvUsers;
    protected UserAdapter adapter2;
    protected List<ParseUser> allUsers;
    protected EditText editText;

    

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
        editText = view.findViewById(R.id.edittext);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());

            }
        });

        allUsers = new ArrayList<>();
        adapter2 = new UserAdapter(getContext(), allUsers);
        //
        //
        rvUsers.setAdapter(adapter2);
        //
        rvUsers.setLayoutManager(new LinearLayoutManager(getContext()));
        queryUser();


    }

    private void filter(String text){

        ArrayList<ParseUser> filteredList = new ArrayList<>();
        for (ParseUser item : allUsers) {

            if (item.get(KEY_NAME).toString().toLowerCase().contains(text.toLowerCase())){

                filteredList.add(item);
            }
        }

        adapter2.filteredList(filteredList);
    }

    protected void queryUser() {


        ParseQuery<ParseUser> query = ParseUser.getQuery();
      //query.include(User.KEY_NAME);
      query.setLimit(20);
      query.addDescendingOrder(UserAdapter.KEY_CREATED_KEY);


       query.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> users, ParseException e) {
                if (e != null){
                    Log.e(TAG, "Issue with getting users", e);
                    return;
                }
                Log.v(TAG + " users",  users.toString());
                for (ParseUser user : users){
                    Log.i(TAG, "User: " + user.get(UserAdapter.KEY_NAME)+ user.get(UserAdapter.KEY_BUSINESS2));
                }

                allUsers.addAll(users);
                adapter2.notifyDataSetChanged();

            }
        });
    }

}

