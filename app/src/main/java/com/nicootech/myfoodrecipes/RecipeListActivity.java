package com.nicootech.myfoodrecipes;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.nicootech.myfoodrecipes.models.Recipe;
import com.nicootech.myfoodrecipes.requests.RecipeApi;
import com.nicootech.myfoodrecipes.requests.ServiceGenerator;
import com.nicootech.myfoodrecipes.requests.responses.RecipeResponse;
import com.nicootech.myfoodrecipes.requests.responses.RecipeSearchResponse;
import com.nicootech.myfoodrecipes.util.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeListActivity extends BaseActivity {

    private static final String TAG = "RecipeListActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        Button button = findViewById(R.id.test);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testRetrofitRequest();
            }
        });


    }
    private void testRetrofitRequest(){
        RecipeApi recipeApi = ServiceGenerator.getRecipeApi();

        //Testing search response
        Call<RecipeSearchResponse> responseCall = recipeApi
                .searchRecipe(
                        Constants.API_KEY,
                        "chicken breast",
                        "1"
                );
        responseCall.enqueue(new Callback<RecipeSearchResponse>() {
            @Override
            public void onResponse(Call<RecipeSearchResponse> call, Response<RecipeSearchResponse> response) {
                Log.d(TAG, "onResponse: server response: "+ response.toString());

                if(response.code() == 200){
                    Log.d(TAG, "onResponse: "+response.body().toString());
                    List<Recipe> recipes = new ArrayList<>(response.body().getRecipes());
                    for(Recipe recipe : recipes){
                        Log.d(TAG, "onResponse: "+recipe.getTitle());
                    }
                }
                else{
                    try {
                        Log.d(TAG, "onResponse: "+response.errorBody().string());

                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<RecipeSearchResponse> call, Throwable t) {

            }
        });
//        // testing get response
//        Call<RecipeResponse> responseCall = recipeApi
//                .getRecipe(
//                        Constants.API_KEY,
//                        "41470"
//                );
//
//        responseCall.enqueue(new Callback<RecipeResponse>() {
//            @Override
//            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
//                Log.d(TAG, "onResponse: Server Response: " + response.toString());
//                if (response.code() == 200) {
//                    Recipe recipe = response.body().getRecipe();
//                    Log.d(TAG, "onResponse: " + recipe.toString());
//                }
//                else{
//                    try {
//                        Log.d(TAG, "onResponse: " + response.errorBody().string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//            @Override
//            public void onFailure(Call<RecipeResponse> call, Throwable t) {
//                Log.d(TAG, "onResponse: ERROR: " + t.getMessage());
//            }
//        });
    }


}