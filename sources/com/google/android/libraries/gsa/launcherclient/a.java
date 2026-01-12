package com.google.android.libraries.gsa.launcherclient;

import android.os.Looper;
import com.google.android.libraries.gsa.launcherclient.AbsServiceStatusChecker;

/* compiled from: AbsServiceStatusChecker.java */
/* loaded from: launcher_client.jar:com/google/android/libraries/gsa/launcherclient/a.class */
final class a implements Runnable {
    final /* synthetic */ AbsServiceStatusChecker.StatusCallback a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Runnable
    public final void run() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Must be called on the main thread.");
        }
        this.a.isRunning(false);
    }

    a(AbsServiceStatusChecker.StatusCallback statusCallback) {
        this.a = statusCallback;
    }
}
