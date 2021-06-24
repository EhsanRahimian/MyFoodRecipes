package com.nicootech.myfoodrecipes.adapters;

import android.app.VoiceInteractor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nicootech.myfoodrecipes.R;
import com.nicootech.myfoodrecipes.models.Recipe;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Recipe>mRecipes;
    private OnRecipeListener mOnRecipeListener;

    public RecipeRecyclerAdapter(List<Recipe> mRecipe, OnRecipeListener mOnRecipeListener) {
        this.mRecipes = mRecipes;
        this.mOnRecipeListener = mOnRecipeListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recipe_list_item, parent,false);
        return new RecipeViewHolder(view,mOnRecipeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);

        Glide.with(viewHolder.itemView.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(mRecipes.get(i))
                .into(((RecipeViewHolder)viewHolder).image);


        ((RecipeViewHolder)viewHolder).title.setText(mRecipes.get(i).getTitle());
        ((RecipeViewHolder)viewHolder).publisher.setText(mRecipes.get(i).getPublisher());
        ((RecipeViewHolder)viewHolder).socialScore.setText(String.valueOf(Math.round(mRecipes.get(i).getSocial_rank())));
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }
    public void setRecipes(List<Recipe>recipes){
        mRecipes = recipes;
        notifyDataSetChanged();
    }
}
