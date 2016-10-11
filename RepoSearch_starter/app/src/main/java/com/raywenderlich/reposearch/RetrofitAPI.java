package com.raywenderlich.reposearch;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by zidansuid on 10/11/16.
 */

public interface RetrofitAPI {

    @GET("/repositories")
    Call<ArrayList<Repository>> retrieveRepositories();


}
