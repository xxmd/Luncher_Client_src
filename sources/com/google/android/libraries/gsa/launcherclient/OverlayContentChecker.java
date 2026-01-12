package com.google.android.libraries.gsa.launcherclient;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.libraries.gsa.launcherclient.AbsServiceStatusChecker;

/* loaded from: launcher_client.jar:com/google/android/libraries/gsa/launcherclient/OverlayContentChecker.class */
public class OverlayContentChecker extends AbsServiceStatusChecker {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public OverlayContentChecker(Context context) {
        super(context);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void checkOverlayContent(AbsServiceStatusChecker.StatusCallback statusCallback) {
        Intent intentB = LauncherClient.b(this.a, "com.google.android.googlequicksearchbox");
        intentB.setPackage("com.google.android.googlequicksearchbox");
        if (this.a.bindService(intentB, new b(this, statusCallback), 1)) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new a(statusCallback));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.gsa.launcherclient.AbsServiceStatusChecker
    protected final boolean a(IBinder iBinder) throws RemoteException {
        return com.google.android.libraries.a.b.b(iBinder).r();
    }
}
