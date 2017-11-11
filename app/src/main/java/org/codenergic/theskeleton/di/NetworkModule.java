package org.codenergic.theskeleton.di;

import android.content.Context;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.codenergic.theskeleton.data.AuthInterceptor;
import org.codenergic.theskeleton.data.helper.TokenManager;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.inject.Singleton;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by putrice on 9/25/17.
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    ObjectMapper providesObjectMapper() {
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(Set<Interceptor> interceptors) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        for (Interceptor interceptor : interceptors) {
            builder.addInterceptor(interceptor);
        }
        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(ObjectMapper objectMapper, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(org.codenergic.theskeleton.data.BuildConfig.BASE)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .client(okHttpClient)
                .build();
    }

    /**
     * Register interceptors here
     *
     * @return list of interceptors
     */
    @Provides
    @Singleton
    Set<Interceptor> providesRetrofitInterceptors(Context context, AuthInterceptor authInterceptor) {
        Set<Interceptor> interceptors = new LinkedHashSet<>();
        interceptors.add(new HttpLoggingInterceptor()
                .setLevel(org.codenergic.theskeleton.BuildConfig.DEBUG ?
                        HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE));
        interceptors.add(authInterceptor);
        return interceptors;
    }

    @Provides
    @Singleton
    AuthInterceptor provideAuthInterceptor(TokenManager tokenManager) {
        return new AuthInterceptor(tokenManager);
    }
}
