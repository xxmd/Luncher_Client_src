package com.google.android.libraries.gsa.launcherclient;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;

/* loaded from: launcher_client.jar:com/google/android/libraries/gsa/launcherclient/AbsServiceStatusChecker.class */
public abstract class AbsServiceStatusChecker {
    final Context a;

    /* loaded from: launcher_client.jar:com/google/android/libraries/gsa/launcherclient/AbsServiceStatusChecker$StatusCallback.class */
    public interface StatusCallback {
        void isRunning(boolean z);
    }

    protected AbsServiceStatusChecker(Context context) {
        this.a = context;
    }

    protected abstract boolean a(IBinder iBinder) throws RemoteException;
}
