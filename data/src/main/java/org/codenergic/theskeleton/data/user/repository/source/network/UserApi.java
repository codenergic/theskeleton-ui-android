package org.codenergic.theskeleton.data.user.repository.source.network;

import org.codenergic.theskeleton.data.user.UserEntity;
import org.codenergic.theskeleton.data.user.repository.source.network.response.LoginResponse;

import io.reactivex.Flowable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by putrice on 10/1/17.
 */

public interface UserApi {

    @POST("oauth/token")
    Flowable<LoginResponse> login(@Query("grant_type") String grantType,
        @Query("username") String username,
        @Query("password") String password);

}
