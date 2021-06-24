package com.nicootech.myfoodrecipes.adapters;

import android.view.View;
import android.widget.TextView;

import com.nicootech.myfoodrecipes.R;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;


public class RecipeViewHolder extends RecyclerView.ViewHolder{

    TextView title, publisher, socialScore;
    AppCompatImageView image;

    public RecipeViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.recipe_title);
        publisher = itemView.findViewById(R.id.recipe_publisher);
        socialScore = itemView.findViewById(R.id.recipe_social_score);
        image = itemView.findViewById(R.id.recipe_image);
    }

}
