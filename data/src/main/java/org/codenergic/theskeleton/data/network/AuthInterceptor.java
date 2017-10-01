package org.codenergic.theskeleton.data.network;

import android.util.Base64;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by putrice on 10/1/17.
 */

public class AuthInterceptor implements Interceptor {

    private final static String clientId = "0000015bb4a150850007bf0700000000";

    private final static String clientSecret =
        "$2a$06$F0YQTRPvG8M9SPzIgk49GOgwOH7jcHaT2elonRrs9mSCftNtEgMmi";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request request = original.newBuilder()
            .header("Content-Type", "application/x-www-form-urlencoded")
            .header("Authorization",
                "Basic " + Base64
                    .encodeToString((clientId + ":" + clientSecret).getBytes(), Base64.NO_WRAP))
            .method(original.method(), original.body())
            .build();

        return chain.proceed(request);
    }
}
