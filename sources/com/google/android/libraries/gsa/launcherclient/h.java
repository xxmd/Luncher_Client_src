package com.google.android.libraries.gsa.launcherclient;

/* compiled from: LauncherClient.java */
/* loaded from: launcher_client.jar:com/google/android/libraries/gsa/launcherclient/h.class */
final class h implements Runnable {
    final /* synthetic */ LauncherClient a;

    h(LauncherClient launcherClient) {
        this.a = launcherClient;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.i.h() && this.a.h.h()) {
            return;
        }
        this.a.c.runOnUiThread(new g(this));
    }
}
