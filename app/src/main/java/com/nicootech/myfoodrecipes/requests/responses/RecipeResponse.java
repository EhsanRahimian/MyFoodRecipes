package com.nicootech.myfoodrecipes.requests.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nicootech.myfoodrecipes.models.Recipe;

public class RecipeResponse {
//https://recipesapi.herokuapp.com/api/get?rId=41470
    @SerializedName("recipe")
    @Expose()
    private Recipe recipe;

    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        return "RecipeResponse{" +
                "recipe=" + recipe +
                '}';
    }
}
