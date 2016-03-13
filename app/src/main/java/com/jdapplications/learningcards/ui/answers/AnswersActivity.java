package com.jdapplications.learningcards.ui.answers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.jdapplications.learningcards.R;
import com.jdapplications.learningcards.data.model.Answer;
import com.jdapplications.learningcards.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AnswersActivity extends BaseActivity implements AnswersMvpView {
    public static final String ANSWERS = "answers";
    public static final String QUESTION = "question";

    @Inject AnswersPresenter answersPresenter;
    @Inject AnswersAdapter answersAdapter;

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.answer_list) RecyclerView recyclerView;

    public static Intent getStartIntent(Context context, ArrayList<Answer> answerList, String question) {
        Intent intent = new Intent(context, AnswersActivity.class);
        intent.putParcelableArrayListExtra(ANSWERS, answerList);
        intent.putExtra(QUESTION, question);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getActivityComponent().inject(this);
        answersPresenter.attachView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(answersAdapter);
        //noinspection ConstantConditions
        getSupportActionBar().setTitle(getIntent().getStringExtra(QUESTION));
        List<Answer> answers = getIntent().getParcelableArrayListExtra(ANSWERS);
        if (!answers.isEmpty()) {
            showAnswers(answers);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        answersPresenter.detachView();
    }

    @Override
    public void showAnswers(List<Answer> answers) {
        answersAdapter.setAnswers(answers);
        answersAdapter.notifyDataSetChanged();
    }
}
