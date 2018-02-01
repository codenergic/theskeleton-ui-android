package org.codenergic.theskeleton.data.user.repository.source.rest;

import org.codenergic.theskeleton.data.user.UserEntity;
import org.codenergic.theskeleton.data.user.repository.source.request.SignUpRequest;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface UserApi {

    @POST("api/register")
    @Headers({"Content-Type: application/json"})
    Flowable<UserEntity> signUp(@Body SignUpRequest signUpRequest);

    @GET("api/profile")
    @Headers({"Content-Type: application/json"})
    Flowable<UserEntity> getUserProfile();

}
