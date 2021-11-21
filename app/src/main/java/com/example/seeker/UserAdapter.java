package com.example.seeker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{


    private Context context;
    private List<User> users;

    public UserAdapter(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }


    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new UserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {

        User user = users.get(position);
        holder.bind(user);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        // private TextView tvUsername;
        private ImageView ivProfilePic;
        private TextView tvBusiness2;
        private TextView tvUsername;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //tvUsername = itemView.findViewById(R.id.tvUsername);
            tvBusiness2 = itemView.findViewById(R.id.tvBusiness2);
            ivProfilePic = itemView.findViewById(R.id.ivProfilePic);
            tvUsername = itemView.findViewById(R.id.tvUsername);
        }

        public void bind(User user) {

            //tvDescription.setText(user.getDescription());
            tvUsername.setText(user.getUsername());
            tvBusiness2.setText(user.getBusiness2());
            ParseFile image = user.getProfilePic();
            if (image != null) {
                Glide.with(context).load(user.getProfilePic().getUrl()).into(ivProfilePic);
            }

        }
    }

    // Clean all elements of the recycler
    public void clear() {
        users.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<User> list) {
        users.addAll(list);
        notifyDataSetChanged();
    }
}
