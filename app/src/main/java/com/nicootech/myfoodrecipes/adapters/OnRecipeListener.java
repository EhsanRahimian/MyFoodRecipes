package com.nicootech.myfoodrecipes.adapters;

public interface OnRecipeListener {
    // to click the single recipe
    void onRecipeClick(int position);
    // to click the category view
    void onCategoryClick(String category);
}
