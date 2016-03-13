package com.jdapplications.learningcards.data.remote;

import com.jdapplications.learningcards.data.model.Category;
import com.jdapplications.learningcards.data.model.CategoryQuestionsResponse;
import com.squareup.moshi.Moshi;

import java.util.List;

import okhttp3.HttpUrl;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * API Service to request all data related
 *
 * @author daniel.hartwich
 */
public interface LearningCardService {
    String API_ENDPOINT = "http://dotards.net:3003/api/v1/";

    @GET("category/{id}")
    Observable<List<Category>> getAvailableCategories(@Path("id") String id);

    @GET("questions/category/{id}")
    Observable<List<CategoryQuestionsResponse>> getAllQuestionsFromCategory(@Path("id") String id);

    class Creator {
        public static LearningCardService newLearningCardService() {
            Moshi moshi = new Moshi.Builder().build();
            Retrofit retrofit = new Retrofit.Builder()
                  .baseUrl(HttpUrl.parse(API_ENDPOINT))
                  .addConverterFactory(MoshiConverterFactory.create(moshi))
                  .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                  .build();
            return retrofit.create(LearningCardService.class);
        }
    }
}
