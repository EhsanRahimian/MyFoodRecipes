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
import com.nicootech.myfoodrecipes.util.Testing;
import com.nicootech.myfoodrecipes.viewmodels.RecipeListViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeListActivity extends BaseActivity {

    private static final String TAG = "RecipeListActivity";

    private RecipeListViewModel mRecipeListViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        //decoration and instantiation of viewModel
        mRecipeListViewModel = new ViewModelProvider(this).get(RecipeListViewModel.class);
        subscribeObservers();

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testRetrofitRequest();
            }
        });
    }

    private void subscribeObservers(){
        mRecipeListViewModel.getRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                if (recipes != null) {
//                    for(Recipe  recipe : recipes){
//                        Log.d(TAG, "onChanged: "+ recipe.getTitle());
//                    }
//                    or bellow
                    Testing.printRecipes(recipes,"recipes test");
                }
            }
        });
    }
    private void searchRecipesApi(String query, int pageNumber){

        mRecipeListViewModel.searchRecipesApi(query,pageNumber);
    }

    private void testRetrofitRequest(){
        searchRecipesApi("chicken breast", 1);
    }


}