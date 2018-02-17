package org.codenergic.theskeleton.helper;

import com.tapadoo.alerter.Alerter;

import org.codenergic.theskeleton.R;

import android.app.Activity;
import android.support.v4.content.ContextCompat;

/**
 * Created by putrice on 2/4/18.
 */
public class AlertHelper {

    public static void showWarningAlert(Activity activity, String text) {
        Alerter.create(activity)
            .setText(text)
            .setBackgroundColorInt(
                ContextCompat.getColor(activity, R.color.sunshade))
            .show();
    }

    public static void showErrorAlert(Activity activity, String text) {
        Alerter.create(activity)
            .setText(text)
            .setBackgroundColorInt(
                ContextCompat.getColor(activity, R.color.flamingo))
            .show();
    }

    public static void showSuccessAlert(Activity activity, String text) {
        Alerter.create(activity)
            .setText(text)
            .setBackgroundColorInt(
                ContextCompat.getColor(activity, R.color.fruitSalad))
            .show();
    }

}
