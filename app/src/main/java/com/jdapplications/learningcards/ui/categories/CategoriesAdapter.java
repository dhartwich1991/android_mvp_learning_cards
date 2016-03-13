package com.jdapplications.learningcards.ui.categories;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jdapplications.learningcards.R;
import com.jdapplications.learningcards.data.model.Category;
import com.jdapplications.learningcards.injection.ActivityContext;
import com.jdapplications.learningcards.ui.categoryquestions.CategoryQuestionsActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author daniel.hartwich
 */
public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {
    private List<Category> categories;
    private final LayoutInflater inflater;
    private final Context activity;

    @Inject
    public CategoriesAdapter(@ActivityContext Context activity) {
        categories = new ArrayList<>(0);
        inflater = LayoutInflater.from(activity);
        this.activity = activity;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Category getCategoryAtPosition(int position) {
        return categories.get(position);
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.card_categories, parent, false);
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.category.setText(category.name());
        holder.subject.setText(category.subject());
        holder.itemView.setTag(category);
        holder.cardView
              .setOnClickListener(v -> {
                  Toast.makeText(activity, "Pressed at " + position, Toast.LENGTH_SHORT).show();
                  activity.startActivity(CategoryQuestionsActivity.getStartIntent(activity, category.name(),
                        String.valueOf(category.id())));
              });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.category_name) TextView category;
        @Bind(R.id.category_subject) TextView subject;
        @Bind(R.id.card_view) CardView cardView;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
