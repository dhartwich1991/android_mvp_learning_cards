package com.jdapplications.learningcards.ui.categoryquestions;

import com.jdapplications.learningcards.data.model.CategoryQuestionsResponse;
import com.jdapplications.learningcards.ui.base.MvpView;

import java.util.List;

/**
 * @author daniel.hartwich
 */
public interface CategoryQuestionsMvpView extends MvpView {
    void showQuestions(List<CategoryQuestionsResponse> questions);
}
