package com.jdapplications.learningcards.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * A Scoping annotation to permit objects whose lifetime should conform to the life of the Activity to be memorised in
 * the correct component.
 *
 * @author daniel.hartwich
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
