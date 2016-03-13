package com.jdapplications.learningcards.ui.categoryquestions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.jdapplications.learningcards.R;
import com.jdapplications.learningcards.data.model.CategoryQuestionsResponse;
import com.jdapplications.learningcards.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryQuestionsActivity extends BaseActivity implements CategoryQuestionsMvpView {
    public static final String CATEGORY = "category";
    public static final String CATEGORY_ID = "category_id";

    @Inject CategoryQuestionsPresenter categoriesQuestionsPresenter;
    @Inject CategoryQuestionsAdapter categoryQuestionsAdapter;

    @Bind(R.id.question_list) RecyclerView questionList;
    @Bind(R.id.toolbar) Toolbar toolbar;

    public static Intent getStartIntent(Context context, String category, String categoryId) {
        Intent intent = new Intent(context, CategoryQuestionsActivity.class);
        intent.putExtra(CATEGORY, category);
        intent.putExtra(CATEGORY_ID, categoryId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_questions);
        getActivityComponent().inject(this);
        categoriesQuestionsPresenter.attachView(this);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setTitle(getIntent().getStringExtra(CATEGORY));
        questionList.setLayoutManager(new LinearLayoutManager(this));
        questionList.setAdapter(categoryQuestionsAdapter);
        categoriesQuestionsPresenter.attachView(this);
        categoriesQuestionsPresenter.loadQuestions(getIntent().getStringExtra(CATEGORY_ID));
    }

    @Override
    public void showQuestions(List<CategoryQuestionsResponse> categoryQuestionsResponses) {
        categoryQuestionsAdapter.setCategories(categoryQuestionsResponses);
        categoryQuestionsAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        categoriesQuestionsPresenter.detachView();
    }
}
