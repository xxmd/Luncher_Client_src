package com.google.android.libraries.gsa.launcherclient;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import java.lang.ref.WeakReference;

/* compiled from: AppServiceConnection.java */
/* loaded from: launcher_client.jar:com/google/android/libraries/gsa/launcherclient/c.class */
final class c extends l {
    private static c a;
    private com.google.android.libraries.a.c b;
    private WeakReference<LauncherClient> c;
    private boolean d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static c a(Context context, Handler handler, String str) {
        c cVar = a;
        if (cVar != null && !str.equals(cVar.f())) {
            cVar.e();
            a = null;
        }
        if (a == null) {
            a = new c(context.getApplicationContext(), handler, str);
        }
        return a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private c(Context context, Handler handler, String str) {
        super(context, 33, handler, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final com.google.android.libraries.a.c b(LauncherClient launcherClient) {
        this.c = new WeakReference<>(launcherClient);
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c(boolean z) {
        this.d = z;
        k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d(LauncherClient launcherClient, boolean z) {
        LauncherClient launcherClientM = m();
        if (launcherClientM == null || !launcherClientM.equals(launcherClient)) {
            return;
        }
        this.c = null;
        if (z) {
            e();
            if (a == this) {
                a = null;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.gsa.launcherclient.l, android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        l(com.google.android.libraries.a.b.b(iBinder));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.gsa.launcherclient.l, android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        l(null);
        k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void k() {
        if (this.d && this.b == null) {
            e();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void l(com.google.android.libraries.a.c cVar) {
        this.b = cVar;
        LauncherClient launcherClientM = m();
        if (launcherClientM != null) {
            launcherClientM.a(this.b);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final LauncherClient m() {
        WeakReference<LauncherClient> weakReference = this.c;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
