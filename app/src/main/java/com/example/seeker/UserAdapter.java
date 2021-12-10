package com.example.seeker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {


    private Context context;
    private List<ParseUser> users;
    private List<ParseUser> usersFull;
    public static final String KEY_PROFILEPIC = "profile";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_BUSINESS2 = "bus_name";
    public static final String KEY_NAME = "name";
    public static final String KEY_CREATED_KEY = "createdAt";
    public static final String KEY_STATUS = "pause";

    public UserAdapter(Context context, List<ParseUser> users) {
        this.context = context;
        this.users = users;
        usersFull = new ArrayList<>(users);
    }


    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new UserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {

        ParseUser user = users.get(position);
        holder.bind(user);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }



    public void filteredList(ArrayList<ParseUser> filteredList) {
        users = filteredList;
        notifyDataSetChanged();

    }


    class ViewHolder extends RecyclerView.ViewHolder {

        // private TextView tvUsername;
        private ImageView ivProfilePic;
        private TextView tvBusiness2;
        private TextView tvUsername;
        private ImageButton btnDelete;
        private Switch btnPause;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //tvUsername = itemView.findViewById(R.id.tvUsername);
            tvBusiness2 = itemView.findViewById(R.id.tvBusiness2);
            ivProfilePic = itemView.findViewById(R.id.ivProfilePic);
            tvUsername = itemView.findViewById(R.id.tvSocialUser);
            btnPause = itemView.findViewById(R.id.btnPause);
            btnDelete = itemView.findViewById(R.id.btnDelete);

        }

        public void bind(ParseUser user) {

            //tvDescription.setText(user.getDescription());
            tvUsername.setText(user.get(KEY_NAME).toString());
            tvBusiness2.setText(user.get(KEY_BUSINESS2).toString());
           /* ParseFile image = user.getProfilePic();
            if (image != null) {
                Glide.with(context).load(user.getProfilePic().getUrl()).into(ivProfilePic);
            }*/

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, DeleteActivity.class);
                    context.startActivity(i);

                }
            });



        }
    }


    // Clean all elements of the recycler
    public void clear() {
        users.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<ParseUser> list) {
        users.addAll(list);
        notifyDataSetChanged();
    }


}
