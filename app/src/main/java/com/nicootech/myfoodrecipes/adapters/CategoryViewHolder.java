package com.nicootech.myfoodrecipes.adapters;

import android.view.View;
import android.widget.TextView;

import com.nicootech.myfoodrecipes.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView categoryTitle;
    CircleImageView categoryImage;
    OnRecipeListener listener;

    public CategoryViewHolder(@NonNull View itemView, OnRecipeListener listener) {
        super(itemView);

        this.listener = listener;
        categoryImage = itemView.findViewById(R.id.category_image);
        categoryTitle = itemView.findViewById(R.id.category_title);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        listener.onCategoryClick(categoryTitle.getText().toString());

    }
}
