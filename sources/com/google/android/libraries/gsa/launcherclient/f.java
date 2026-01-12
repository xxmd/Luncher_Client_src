package com.google.android.libraries.gsa.launcherclient;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

/* compiled from: LauncherClient.java */
/* loaded from: launcher_client.jar:com/google/android/libraries/gsa/launcherclient/f.class */
final class f extends BroadcastReceiver {
    final /* synthetic */ LauncherClient a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    f(LauncherClient launcherClient) {
        this.a = launcherClient;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if (Build.VERSION.SDK_INT >= 19 || (data != null && this.a.n.b.equals(data.getSchemeSpecificPart()))) {
            this.a.h.e();
            this.a.i.e();
            this.a.t(context);
            if ((this.a.k & 2) != 0) {
                this.a.reconnect();
            }
        }
    }
}
