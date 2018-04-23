package com.commlibs.utils.common;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.preference.Preference;

/**
 * @author Oasis
 */
public class GooglePlayStore {

    public static final String PACKAGE_NAME = "com.android.vending";
    private static final String APP_URL_PREFIX = "https://play.google.com/store/apps/details?id=";

    public static void showApp(final Context context, final String pkg) {
        final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(APP_URL_PREFIX + pkg));
        updatePlayUrlIntent(context, intent);
        try {
            context.startActivity(intent);
        } catch (final ActivityNotFoundException e) { /* In case of Google Play malfunction */ }
    }

    public static void updatePreferenceIntent(final Context context, final Preference preference) {
        final Intent intent = preference.getIntent();
        updatePlayUrlIntent(context, intent);
    }

    /**
     * Modify intent to launch Google Play Store directly if possible (without opener-app selector)
     */
    private static void updatePlayUrlIntent(final Context context, final Intent intent) {
        if (intent == null || intent.getPackage() != null)
            return;      // Skip intent with explicit target package
        final Uri uri = intent.getData();
        if (uri == null) return;
        intent.setPackage(PACKAGE_NAME);
        final ComponentName component = intent.resolveActivity(context.getPackageManager());
        if (component != null) intent.setComponent(component);
        else intent.setPackage(null);
    }
}
