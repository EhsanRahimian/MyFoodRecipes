package com.nicootech.myfoodrecipes;

import android.os.Bundle;
import androidx.appcompat.widget.SearchView;

import com.nicootech.myfoodrecipes.adapters.OnRecipeListener;
import com.nicootech.myfoodrecipes.adapters.RecipeRecyclerAdapter;
import com.nicootech.myfoodrecipes.models.Recipe;

import com.nicootech.myfoodrecipes.util.Testing;
import com.nicootech.myfoodrecipes.viewmodels.RecipeListViewModel;

import java.util.List;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class RecipeListActivity extends BaseActivity implements OnRecipeListener {

    private static final String TAG = "RecipeListActivity";

    private RecipeListViewModel mRecipeListViewModel;
    private RecyclerView mRecyclerView;
    private RecipeRecyclerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        mRecyclerView = findViewById(R.id.recipe_list);
        //decoration and instantiation of viewModel
        mRecipeListViewModel = new ViewModelProvider(this).get(RecipeListViewModel.class);

        initRecyclerView();
        subscribeObservers();
        initSearchView();
        if(!mRecipeListViewModel.isViewingRecipes()){
            // display search categories
            displaySearchCategories();
        }
    }

    private void subscribeObservers(){
        mRecipeListViewModel.getRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                if (recipes != null) {
                    Testing.printRecipes(recipes,"recipes test");
                    //setting the data
                    mAdapter.setRecipes(recipes);
                }

            }
        });
    }

    private void initRecyclerView(){
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecipeRecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initSearchView(){
        final SearchView searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                mAdapter.displayLoading();
                mRecipeListViewModel.searchRecipesApi(query,1);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void onRecipeClick(int position) {

    }

    @Override
    public void onCategoryClick(String category) {
        mAdapter.displayLoading();
        mRecipeListViewModel.searchRecipesApi(category,1);
    }

    private void displaySearchCategories(){
        mRecipeListViewModel.setIsViewingRecipes(false);
        mAdapter.displaySearchCategories();
    }
}