package com.nicootech.myfoodrecipes.repositories;

import com.nicootech.myfoodrecipes.models.Recipe;
import com.nicootech.myfoodrecipes.requests.RecipeApiClient;

import java.util.List;

import androidx.lifecycle.LiveData;


public class RecipeRepository {

    private static RecipeRepository instance;
    private RecipeApiClient mRecipeApiClient;

    private String mQuery;
    private int mPageNumber;

    public static RecipeRepository getInstance(){
        if(instance == null){
            instance = new RecipeRepository();
        }
        return instance;
    }

    private RecipeRepository() {
        mRecipeApiClient = RecipeApiClient.getInstance();
    }

    public LiveData<List<Recipe>> getRecipes(){
        return mRecipeApiClient.getRecipes();
    }
    public LiveData<Recipe> getRecipe(){
        return mRecipeApiClient.getRecipe();
    }
    public void searchRecipeById(String recipeId){
        mRecipeApiClient.searchRecipeById(recipeId);
    }

    public void searchRecipesApi(String query, int pageNumber){
        if(pageNumber == 0){
            pageNumber = 1;
        }
        mQuery = query;
        mPageNumber = pageNumber;
        mRecipeApiClient.searchRecipesApi(query,pageNumber);
    }

    //that's how we can search the next page
    public void searchNextPage(){
        searchRecipesApi(mQuery,mPageNumber+1);
    }

    public void cancelRequest(){
        mRecipeApiClient.cancelRequest();
    }
}
