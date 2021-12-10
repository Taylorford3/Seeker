package com.example.seeker;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class SocialAdapter extends RecyclerView.Adapter<SocialAdapter.ViewHolder> {

    private Context context;
    private List<Social> socials;

    public SocialAdapter(Context context, List<Social> socials) {
        this.context = context;
        this.socials = socials;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_social, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Social social = socials.get(position);
        holder.bind(social);

    }

    @Override
    public int getItemCount() {
        return socials.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvSocialUser;
        private ImageView ivPhoto;
        private TextView tvCaption;
        LinearLayout container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSocialUser = itemView.findViewById(R.id.tvSocialUser);
            ivPhoto = itemView.findViewById(R.id.ivPhoto);
            tvCaption = itemView.findViewById(R.id.tvCaption);
            container = itemView.findViewById(R.id.container);
        }

        public void bind(Social social) {

            tvCaption.setText(social.getCaption());
            tvSocialUser.setText(social.getSocialUser().getUsername());
            ParseFile photo = social.getPhoto();
            if (photo != null) {
                Glide.with(context).load(social.getPhoto().getUrl()).into(ivPhoto);

            }


        }


    }

    // Clean all elements of the recycler
    public void clear() {
        socials.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Social> list) {
        socials.addAll(list);
        notifyDataSetChanged();
    }


}

