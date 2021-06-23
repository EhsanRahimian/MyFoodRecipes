package com.nicootech.myfoodrecipes.util;

import android.util.Log;

import com.nicootech.myfoodrecipes.models.Recipe;

import java.util.List;

public class Testing {

    private static final String TAG = "Testing";
    public static void printRecipes(List<Recipe>list, String tag){
        for(Recipe recipe: list){
            Log.d(tag, "printRecipes: "+recipe.getTitle());
        }
    }
}
