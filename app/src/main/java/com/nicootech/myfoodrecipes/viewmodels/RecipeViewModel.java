package com.nicootech.myfoodrecipes.viewmodels;

import com.nicootech.myfoodrecipes.models.Recipe;
import com.nicootech.myfoodrecipes.repositories.RecipeRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class RecipeViewModel extends ViewModel {

    private RecipeRepository mRecipeRepository;
    private String mRecipeId;
    private boolean mDidRetrievedRecipe;

    public RecipeViewModel() {
        mRecipeRepository =RecipeRepository.getInstance();
        mDidRetrievedRecipe = false;
    }

    public LiveData<Recipe>getRecipe(){
        return mRecipeRepository.getRecipe();
    }

    public LiveData<Boolean> isRecipeRequestTimedOut(){
        return mRecipeRepository.isRecipeRequestTimedOut();
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

    public void setRetrievedRecipe(boolean retrievedRecipe) {
        mDidRetrievedRecipe = retrievedRecipe;
    }

    public boolean didRetrievedRecipe() {
        return mDidRetrievedRecipe;
    }


}
