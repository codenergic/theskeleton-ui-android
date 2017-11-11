package org.codenergic.theskeleton.data.authentication.repository.source.rest;

import org.codenergic.theskeleton.data.authentication.AuthenticationEntity;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AuthenticationApi {

    @FormUrlEncoded
    @POST("oauth/token?grant_type=password")
    Flowable<AuthenticationEntity> authenticate(@Field("username") String username,
        @Field("password") String password);

}
