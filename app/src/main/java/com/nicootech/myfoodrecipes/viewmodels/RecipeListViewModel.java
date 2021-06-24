package com.nicootech.myfoodrecipes.viewmodels;

import com.nicootech.myfoodrecipes.models.Recipe;
import com.nicootech.myfoodrecipes.repositories.RecipeRepository;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecipeListViewModel extends ViewModel {

    private boolean mIsViewingRecipes;
    private RecipeRepository mRecipeRepository;

    public RecipeListViewModel() {
        mIsViewingRecipes = false;
        mRecipeRepository = RecipeRepository.getInstance();
    }

    public LiveData<List<Recipe>> getRecipes(){
        return mRecipeRepository.getRecipes();
    }

    public void searchRecipesApi(String query, int pageNumber){
        mIsViewingRecipes = true;
        mRecipeRepository.searchRecipesApi(query,pageNumber);
    }
    public boolean isViewingRecipes(){
        return mIsViewingRecipes;
    }

    public void setIsViewingRecipes(boolean isViewingRecipes){
        mIsViewingRecipes = isViewingRecipes;
    }
}
