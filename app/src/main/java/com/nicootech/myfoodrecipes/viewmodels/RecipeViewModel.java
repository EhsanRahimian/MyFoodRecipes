package com.nicootech.myfoodrecipes.viewmodels;

import com.nicootech.myfoodrecipes.models.Recipe;
import com.nicootech.myfoodrecipes.repositories.RecipeRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class RecipeViewModel extends ViewModel {

    private RecipeRepository mRecipeRepository;

    public RecipeViewModel() {
        this.mRecipeRepository =RecipeRepository.getInstance();
    }

    public LiveData<Recipe>getRecipe(){
        return mRecipeRepository.getRecipe();
    }

    public void searchRecipeById(String recipeId){
        mRecipeRepository.searchRecipeById(recipeId);
    }

}
