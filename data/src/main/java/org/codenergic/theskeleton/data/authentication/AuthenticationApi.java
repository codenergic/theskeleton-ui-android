package org.codenergic.theskeleton.data.authentication;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AuthenticationApi {
    @FormUrlEncoded
    @POST("oauth/token?grant_type=password")
    Flowable<AuthenticationResponseEntity> authenticate(@Field("username") String username, @Field("password") String password);
}
