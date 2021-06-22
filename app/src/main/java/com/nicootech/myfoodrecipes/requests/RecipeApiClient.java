package com.nicootech.myfoodrecipes.requests;

import com.nicootech.myfoodrecipes.models.Recipe;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class RecipeApiClient {

    private static RecipeApiClient instance;

    private MutableLiveData<List<Recipe>> mRecipes;

    public static RecipeApiClient getInstance(){
        if(instance == null){
            instance = new RecipeApiClient();
        }
        return instance;
    }

    public RecipeApiClient() {
        mRecipes = new MutableLiveData<>();
    }
    public LiveData<List<Recipe>> getRecipes(){
        return mRecipes;
    }
}
