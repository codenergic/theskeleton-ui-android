package org.codenergic.theskeleton.domain.authentication.interactor;

import android.content.Context;
import android.content.SharedPreferences;
import io.reactivex.Flowable;
import org.codenergic.theskeleton.domain.UseCase;
import org.codenergic.theskeleton.domain.authentication.Authentication;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Calendar;

@Singleton
public class SaveAuthentication extends UseCase<Authentication, Authentication> {
    private static final String SESSION = "session";
    private final Context context;

    @Inject
    public SaveAuthentication(Context context) {
        this.context = context;
    }

    @Override
    protected Flowable<Authentication> buildUseCaseFlowable(Authentication authentication) {
        SharedPreferences prefs = context.getSharedPreferences(SESSION, Context.MODE_PRIVATE);
        prefs.edit()
                .putString("accessToken", authentication.getAccessToken())
                .putString("refreshToken", authentication.getRefreshToken())
                .putLong("expiresIn", authentication.getExpiresIn())
                .putLong("expiredAt", Calendar.getInstance().getTimeInMillis() + (authentication.getExpiresIn() * 1000))
                .apply();
        return Flowable.just(authentication);
    }
}
