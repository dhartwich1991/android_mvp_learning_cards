package com.jdapplications.learningcards.ui.answers;

import com.jdapplications.learningcards.data.model.Answer;
import com.jdapplications.learningcards.ui.base.MvpView;

import java.util.List;

/**
 * @author daniel.hartwich
 */
public interface AnswersMvpView extends MvpView {
    void showAnswers(List<Answer> answers);
}
