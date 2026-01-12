package com.google.android.libraries.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ILauncherOverlayCallback.java */
/* loaded from: launcher_client.jar:com/google/android/libraries/a/d.class */
public abstract class d extends com.google.android.a.b implements e {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.a.b
    protected final boolean a(int i, Parcel parcel) throws RemoteException {
        switch (i) {
            case 1:
                d(parcel.readFloat());
                return true;
            case 2:
                e(parcel.readInt());
                return true;
            case 3:
                f((Bundle) com.google.android.a.c.c(parcel, Bundle.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
