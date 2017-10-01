package org.codenergic.theskeleton.data;

import android.util.Base64;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AuthInterceptor implements Interceptor {
    private static final String CLIENT_ID = "0000015bb4a150850007bf0700000000";
    private static final String CLIENT_SECRET = "$2a$06$F0YQTRPvG8M9SPzIgk49GOgwOH7jcHaT2elonRrs9mSCftNtEgMmi";
    private final String authorizationHeader;

    public AuthInterceptor() {
        this.authorizationHeader = "Basic " + Base64
                .encodeToString((CLIENT_ID + ":" + CLIENT_SECRET).getBytes(), Base64.NO_WRAP);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        if (!original.url().encodedPath().equals("/oauth/token"))
            return chain.proceed(original);
        Request request = original.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Authorization", authorizationHeader)
                .method(original.method(), original.body())
                .build();
        return chain.proceed(request);
    }
}
