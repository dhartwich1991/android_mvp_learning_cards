package com.jdapplications.learningcards.ui.categories;

import com.jdapplications.learningcards.data.model.Category;
import com.jdapplications.learningcards.ui.base.MvpView;

import java.util.List;

/**
 * @author daniel.hartwich
 */
public interface CategoriesMvpView extends MvpView {
    void showCategories(List<Category> categories);
}
