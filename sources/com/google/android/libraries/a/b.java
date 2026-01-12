package com.google.android.libraries.a;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: ILauncherOverlay.java */
/* loaded from: launcher_client.jar:com/google/android/libraries/a/b.class */
public abstract class b extends com.google.android.a.b implements c {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static c b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.libraries.launcherclient.ILauncherOverlay");
        return iInterfaceQueryLocalInterface instanceof c ? (c) iInterfaceQueryLocalInterface : new a(iBinder);
    }
}
