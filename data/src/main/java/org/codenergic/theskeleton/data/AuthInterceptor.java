package org.codenergic.theskeleton.data;

import android.content.SharedPreferences;
import android.util.Base64;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import javax.annotation.ParametersAreNonnullByDefault;
import java.io.IOException;

public class AuthInterceptor implements Interceptor {
    private static final String CLIENT_ID = "0000015bb4a150850007bf0700000000";
    private static final String CLIENT_SECRET = "$2a$06$F0YQTRPvG8M9SPzIgk49GOgwOH7jcHaT2elonRrs9mSCftNtEgMmi";
    private final String loginAuthorizationHeader;
    private final SharedPreferences sharedPreferences;

    public AuthInterceptor(SharedPreferences sharedPreferences) {
        this.loginAuthorizationHeader = "Basic " + Base64
                .encodeToString((CLIENT_ID + ":" + CLIENT_SECRET).getBytes(), Base64.NO_WRAP);
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    @ParametersAreNonnullByDefault
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        String accessToken = sharedPreferences.getString("accessToken", "");
        if (original.url().encodedPath().equals("/oauth/token")) {
            return chain.proceed(original.newBuilder()
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Authorization", loginAuthorizationHeader)
                    .build());
        } else if (accessToken.isEmpty()) {
            return chain.proceed(original);
        } else {
            return chain.proceed(original.newBuilder()
                    .header("Authorization", "Bearer " + accessToken)
                    .build());
        }
    }
}
