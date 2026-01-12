package com.google.android.libraries.gsa.launcherclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

/* compiled from: SimpleServiceConnection.java */
/* loaded from: launcher_client.jar:com/google/android/libraries/gsa/launcherclient/l.class */
class l implements ServiceConnection {
    private final Context a;
    private final int b;
    private final Handler c;
    private final Runnable d = new k(this);
    private final String e;
    private boolean f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    l(Context context, int i, Handler handler, String str) {
        this.a = context;
        this.b = i;
        this.c = handler;
        this.e = str;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e() {
        i(this.c, this.d);
    }

    public final String f() {
        return this.e;
    }

    public final boolean g() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean h() {
        if (this.c.getLooper() != Looper.myLooper()) {
            throw new IllegalThreadStateException();
        }
        if (!this.f) {
            try {
                Context context = this.a;
                this.f = context.bindService(LauncherClient.b(context, this.e), this, this.b);
            } catch (SecurityException e) {
                Log.e("LauncherClient", "Unable to connect to overlay service", e);
            }
        }
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void i(Handler handler, Runnable runnable) {
        if (handler.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    static /* synthetic */ void j(l lVar) {
        if (lVar.f) {
            lVar.a.unbindService(lVar);
            lVar.f = false;
        }
    }
}
