package com.jdapplications.learningcards.ui.categories;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jdapplications.learningcards.R;
import com.jdapplications.learningcards.data.model.Category;
import com.jdapplications.learningcards.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoriesActivity extends BaseActivity implements CategoriesMvpView {
    @Inject CategoriesPresenter categoriesPresenter;
    @Inject CategoriesAdapter categoriesAdapter;

    @Bind(R.id.category_recycler) RecyclerView categoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        //noinspection ConstantConditions
        getSupportActionBar().setTitle("Kategorie auswählen");
        categoryRecyclerView.setAdapter(categoriesAdapter);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoriesPresenter.attachView(this);
        categoriesPresenter.loadCategories();
    }

    @Override
    public void showCategories(List<Category> categories) {
        categoriesAdapter.setCategories(categories);
        categoriesAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        categoriesPresenter.detachView();
    }
}
