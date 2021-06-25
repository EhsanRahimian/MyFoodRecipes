package com.nicootech.myfoodrecipes.viewmodels;

import com.nicootech.myfoodrecipes.models.Recipe;
import com.nicootech.myfoodrecipes.repositories.RecipeRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class RecipeViewModel extends ViewModel {

    private RecipeRepository mRecipeRepository;
    private String mRecipeId;

    public RecipeViewModel() {
        this.mRecipeRepository =RecipeRepository.getInstance();
    }

    public LiveData<Recipe>getRecipe(){
        return mRecipeRepository.getRecipe();
    }

    public void searchRecipeById(String recipeId){
        mRecipeId = recipeId;
        mRecipeRepository.searchRecipeById(recipeId);
    }
    // for solving the problem for showing up
    // the progress bar for second click on recipe item.
    public String getRecipeId(){
        return mRecipeId;
    }

}
