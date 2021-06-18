package com.nicootech.myfoodrecipes.requests;


import com.nicootech.myfoodrecipes.requests.responses.RecipeResponse;
import com.nicootech.myfoodrecipes.requests.responses.RecipeSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeApi {
    //SEARCH => https://recipesapi.herokuapp.com/api/search
    @GET("api/search")
    Call<RecipeSearchResponse> searchRecipe(
            @Query("key") String key,
            @Query("q") String query,
            @Query("page") String page
    );

    //GET => https://recipesapi.herokuapp.com/api/get?rId=41470
    @GET("api/get")
    Call<RecipeResponse> getRecipe(
            @Query("key") String key,
            @Query("rId") String recipe_id
    );
}
