package com.jdapplications.learningcards.ui.answers;

import android.R.color;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jdapplications.learningcards.R;
import com.jdapplications.learningcards.data.model.Answer;
import com.jdapplications.learningcards.injection.ActivityContext;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author daniel.hartwich
 */
public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.AnswerViewHolder> {
    private final LayoutInflater inflater;
    private final Context activity;
    private List<Answer> answers;

    @Inject
    public AnswersAdapter(@ActivityContext Context activity) {
        answers = new ArrayList<>(0);
        inflater = LayoutInflater.from(activity);
        this.activity = activity;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public AnswersAdapter.AnswerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.card_categories, parent, false);
        return new AnswerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AnswersAdapter.AnswerViewHolder holder, int position) {
        Answer answer = answers.get(position);
        holder.category.setText(answer.getAnswer());
        holder.subject.setText(answer.getCorrect().toString());
        holder.itemView.setTag(answer);
        holder.cardView
              .setOnClickListener(v -> {
                  Toast.makeText(activity, "Pressed at " + position + " Answer was correct: "
                        + answer.getCorrect(), Toast.LENGTH_SHORT).show();
                  if (answer.getCorrect()) {
                      v.setBackgroundColor(activity.getResources().getColor(color.holo_green_light));
                  } else {
                      v.setBackgroundColor(activity.getResources().getColor(color.holo_red_light));
                  }
              });
    }

    @Override
    public int getItemCount() {
        return answers.size();
    }

    static class AnswerViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.category_name) TextView category;
        @Bind(R.id.category_subject) TextView subject;
        @Bind(R.id.card_view) CardView cardView;

        public AnswerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
