package com.nicootech.myfoodrecipes.adapters;

import android.app.VoiceInteractor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nicootech.myfoodrecipes.R;
import com.nicootech.myfoodrecipes.models.Recipe;
import com.nicootech.myfoodrecipes.util.Constants;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int RECIPE_TYPE = 1;
    private static final int LOADING_TYPE = 2;
    private static final int CATEGORY_TYPE = 3;
    private List<Recipe>mRecipes;
    private OnRecipeListener mOnRecipeListener;

    public RecipeRecyclerAdapter(OnRecipeListener mOnRecipeListener) {

        this.mOnRecipeListener = mOnRecipeListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = null;
        switch (i){
            case RECIPE_TYPE:{
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recipe_list_item, parent,false);
                return new RecipeViewHolder(view,mOnRecipeListener);

            }
            case LOADING_TYPE:{
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_loading_list_item, parent,false);
                return new LoadingViewHolder(view);

            }
            case CATEGORY_TYPE:{
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_category_list_item, parent,false);
                return new CategoryViewHolder(view,mOnRecipeListener);

            }
            default:{
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recipe_list_item, parent,false);
                return new RecipeViewHolder(view,mOnRecipeListener);

            }
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        int itemViewType = getItemViewType(i);
        if(itemViewType == RECIPE_TYPE){

            RequestOptions requestOptions = new RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background);

            Glide.with(viewHolder.itemView.getContext())
                    .setDefaultRequestOptions(requestOptions)
                    .load(mRecipes.get(i).getImage_url())
                    .into(((RecipeViewHolder)viewHolder).image);


            ((RecipeViewHolder)viewHolder).title.setText(mRecipes.get(i).getTitle());
            ((RecipeViewHolder)viewHolder).publisher.setText(mRecipes.get(i).getPublisher());
            ((RecipeViewHolder)viewHolder).socialScore.setText(String.valueOf(Math.round(mRecipes.get(i).getSocial_rank())));

        }
        else if(itemViewType == CATEGORY_TYPE){

            RequestOptions requestOptions = new RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background);

            // Referencing the images and titles in constants class inside of recyclerViewAdapter
            Uri path = Uri.parse("android.resource://com.nicootech.myfoodrecipes/drawable/" + mRecipes.get(i).getImage_url());
            Glide.with(((CategoryViewHolder)viewHolder).itemView)
                    .setDefaultRequestOptions(requestOptions)
                    .load(path)
                    .into(((CategoryViewHolder)viewHolder).categoryImage);


            ((CategoryViewHolder)viewHolder).categoryTitle.setText(mRecipes.get(i).getTitle());

        }
    }
    //we are setting the view_types by
    // isLoading(),
    // displayLoading(),
    // and overriding getItemViewType(int position)
    private boolean isLoading(){
        if(mRecipes != null){
            if(mRecipes.size()>0){
                if(mRecipes.get(mRecipes.size()-1).getTitle().equals("LOADING...")){
                    return true;
                }
            }
        }
        return false;
    }
    public void displayLoading(){
        if(!isLoading()){
            Recipe recipe = new Recipe();
            recipe.setTitle("LOADING...");
            List<Recipe> loadingList = new ArrayList<>();
            loadingList.add(recipe);
            mRecipes = loadingList;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(mRecipes.get(position).getSocial_rank() == -1){ // we use the social_rank as a marker
            return CATEGORY_TYPE;
        }
        else if(mRecipes.get(position).getTitle().equals("LOADING...")){
            return LOADING_TYPE;
        }
        else if(position == mRecipes.size() - 1
                && position != 0
                //&& !mRecipes.get(position).getTitle().equals("EXHAUSTED...") // we use it later
        ){
            return LOADING_TYPE;
        }
        else{
            return RECIPE_TYPE;
        }
    }

    public void displaySearchCategories(){
        List<Recipe> categories = new ArrayList<>();
        for(int i = 0; i < Constants.DEFAULT_SEARCH_CATEGORIES.length; i++){
            Recipe recipe = new Recipe();
            recipe.setTitle(Constants.DEFAULT_SEARCH_CATEGORIES[i]);
            recipe.setImage_url(Constants.DEFAULT_SEARCH_CATEGORY_IMAGES[i]);
            recipe.setSocial_rank(-1);
            categories.add(recipe);
        }
        mRecipes = categories;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mRecipes != null) {
            return mRecipes.size();
        }
        return 0;
    }
    public void setRecipes(List<Recipe>recipes){
        mRecipes = recipes;
        notifyDataSetChanged();
    }
}
