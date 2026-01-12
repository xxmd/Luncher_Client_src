package com.google.android.libraries.gsa.launcherclient;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;

/* loaded from: launcher_client.jar:com/google/android/libraries/gsa/launcherclient/SharedOverlayCallbacks.class */
public interface SharedOverlayCallbacks extends LauncherClientCallbacks {
    void onGoogleOverlayTransitionComplete();

    void onGoogleOverlayIconChanged(Bitmap bitmap);

    void onGoogleOverlayBannerChanged(String str, Icon icon);

    void onSharedOverlaySwitchInitiated();
}
