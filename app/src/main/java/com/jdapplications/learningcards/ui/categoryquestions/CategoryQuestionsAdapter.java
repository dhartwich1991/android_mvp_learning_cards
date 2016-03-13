package com.jdapplications.learningcards.ui.categoryquestions;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jdapplications.learningcards.R;
import com.jdapplications.learningcards.data.model.Answer;
import com.jdapplications.learningcards.data.model.CategoryQuestionsResponse;
import com.jdapplications.learningcards.injection.ActivityContext;
import com.jdapplications.learningcards.ui.answers.AnswersActivity;
import com.jdapplications.learningcards.ui.categoryquestions.CategoryQuestionsAdapter.CategoryQuestionsViewHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author daniel.hartwich
 */
public class CategoryQuestionsAdapter extends RecyclerView.Adapter<CategoryQuestionsViewHolder> {
    private List<CategoryQuestionsResponse> categoryQuestionsResponses;
    private final LayoutInflater inflater;
    private final Context activity;

    @Inject
    public CategoryQuestionsAdapter(@ActivityContext Context activity) {
        categoryQuestionsResponses = new ArrayList<>(0);
        inflater = LayoutInflater.from(activity);
        this.activity = activity;
    }

    public void setCategories(List<CategoryQuestionsResponse> categoryQuestionsResponses) {
        this.categoryQuestionsResponses = categoryQuestionsResponses;
    }

    @Override
    public CategoryQuestionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.card_question, parent, false);
        return new CategoryQuestionsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryQuestionsViewHolder holder, int position) {
        CategoryQuestionsResponse categoryQuestion = categoryQuestionsResponses.get(position);
        holder.question.setText(categoryQuestion.getQuestion().getQuestion());
        ArrayList<Answer> answerArrayList = (ArrayList<Answer>) categoryQuestionsResponses.get(position).getAnswers();
        holder.cardView.setOnClickListener(view -> activity.startActivity(AnswersActivity.getStartIntent(activity,
              answerArrayList, categoryQuestion.getQuestion().getQuestion())));
    }

    @Override
    public int getItemCount() {
        return categoryQuestionsResponses.size();
    }

    static class CategoryQuestionsViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.question) TextView question;
        @Bind(R.id.card_view) CardView cardView;

        public CategoryQuestionsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
