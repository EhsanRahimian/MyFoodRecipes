package com.nicootech.myfoodrecipes.repositories;

import com.nicootech.myfoodrecipes.models.Recipe;
import com.nicootech.myfoodrecipes.requests.RecipeApiClient;

import java.util.List;

import androidx.lifecycle.LiveData;


public class RecipeRepository {

    private static RecipeRepository instance;
    private RecipeApiClient mRecipeApiClient;

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
}
