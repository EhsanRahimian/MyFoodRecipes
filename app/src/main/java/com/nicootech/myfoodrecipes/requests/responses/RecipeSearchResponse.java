package com.nicootech.myfoodrecipes.requests.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nicootech.myfoodrecipes.models.Recipe;

import java.util.List;

public class RecipeSearchResponse {
//https://recipesapi.herokuapp.com/api/search?q=chicken&page=1
    @SerializedName("count")
    @Expose()
    private int count;

    @SerializedName("recipes")
    @Expose()
    private List<Recipe> recipes;

    public int getCount() {
        return count;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public String toString() {
        return "RecipeSearchResponse{" +
                "count=" + count +
                ", recipes=" + recipes +
                '}';
    }
}
