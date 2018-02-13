package org.codenergic.theskeleton.helper;

import android.app.Activity;
import android.support.v4.content.ContextCompat;

import com.tapadoo.alerter.Alerter;

/**
 * Created by putrice on 2/4/18.
 */
public class AlertHelper {

    public void showWarningAlert(Activity activity, String text) {
        Alerter.create(activity)
            .setText(text)
            .setIcon(android.R.drawable.stat_sys_warning)
            .setBackgroundColorInt(
                ContextCompat.getColor(activity, android.R.color.holo_orange_dark))
            .show();
    }

}
