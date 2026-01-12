package com.google.android.libraries.gsa.launcherclient;

import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.view.Window;
import android.view.WindowManager;

/* compiled from: LauncherClient.java */
/* loaded from: launcher_client.jar:com/google/android/libraries/gsa/launcherclient/i.class */
final class i extends com.google.android.libraries.a.d implements Handler.Callback {
    private final Handler a = new Handler(Looper.getMainLooper(), this);
    private LauncherClient b;
    private WindowManager c;
    private int d;
    private Window e;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    i() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b(LauncherClient launcherClient) {
        this.b = launcherClient;
        this.c = launcherClient.c.getWindowManager();
        Point point = new Point();
        (Build.VERSION.SDK_INT >= 30 ? launcherClient.c.getDisplay() : this.c.getDefaultDisplay()).getRealSize(point);
        this.d = -Math.max(point.x, point.y);
        this.e = launcherClient.c.getWindow();
    }

    public final void c() {
        this.b = null;
        this.c = null;
        this.e = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.a.e
    public final void d(float f) throws RemoteException {
        this.a.removeMessages(2);
        Message.obtain(this.a, 2, Float.valueOf(f)).sendToTarget();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.a.e
    public final void e(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("service_status", i);
        f(bundle);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.a.e
    public final void f(Bundle bundle) {
        Message.obtain(this.a, 5, 0, 0, bundle).sendToTarget();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (this.b == null) {
            return true;
        }
        switch (message.what) {
            case 2:
                if ((this.b.m & 1) != 0) {
                    float fFloatValue = ((Float) message.obj).floatValue();
                    this.b.d.onOverlayScrollChanged(fFloatValue);
                    if (fFloatValue > 0.0f) {
                        if (fFloatValue < 1.0f) {
                            this.b.g.c("onScroll", fFloatValue);
                            break;
                        } else {
                            this.b.g.a("onScroll 1, overlay opened");
                            break;
                        }
                    } else {
                        this.b.g.a("onScroll 0, overlay closed");
                        break;
                    }
                }
                break;
            case 3:
                WindowManager.LayoutParams attributes = this.e.getAttributes();
                if (((Boolean) message.obj).booleanValue()) {
                    attributes.x = this.d;
                    attributes.flags |= 512;
                } else {
                    attributes.x = 0;
                    attributes.flags &= -513;
                }
                this.c.updateViewLayout(this.e.getDecorView(), attributes);
                break;
            case 5:
                Bundle bundle = (Bundle) message.obj;
                this.b.g.b("stateChanged", message.arg1);
                LauncherClient.l(this.b, bundle);
                break;
        }
        return true;
    }
}
