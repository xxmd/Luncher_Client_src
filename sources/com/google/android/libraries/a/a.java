package com.google.android.libraries.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.WindowManager;

/* compiled from: ILauncherOverlay.java */
/* loaded from: launcher_client.jar:com/google/android/libraries/a/a.class */
public final class a extends com.google.android.a.a implements c {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    a(IBinder iBinder) {
        super(iBinder);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.a.c
    public final void d() throws RemoteException {
        b(1, a());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.a.c
    public final void e(float f) throws RemoteException {
        Parcel parcelA = a();
        parcelA.writeFloat(f);
        b(2, parcelA);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.a.c
    public final void f() throws RemoteException {
        b(3, a());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.a.c
    public final void g(WindowManager.LayoutParams layoutParams, e eVar, int i) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.a.c.d(parcelA, layoutParams);
        com.google.android.a.c.e(parcelA, eVar);
        parcelA.writeInt(i);
        b(4, parcelA);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.a.c
    public final void h(Bundle bundle, e eVar) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.a.c.d(parcelA, bundle);
        com.google.android.a.c.e(parcelA, eVar);
        b(14, parcelA);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.a.c
    public final void i(boolean z) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.a.c.b(parcelA, z);
        b(5, parcelA);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.a.c
    public final void j(int i) throws RemoteException {
        Parcel parcelA = a();
        parcelA.writeInt(i);
        b(6, parcelA);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.a.c
    public final void k(Bundle bundle) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.a.c.d(parcelA, bundle);
        b(19, parcelA);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.a.c
    public final void l() throws RemoteException {
        b(7, a());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.a.c
    public final void m() throws RemoteException {
        b(8, a());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.a.c
    public final void n(int i) throws RemoteException {
        Parcel parcelA = a();
        parcelA.writeInt(i);
        b(16, parcelA);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.a.c
    public final void o(int i) throws RemoteException {
        Parcel parcelA = a();
        parcelA.writeInt(i);
        b(9, parcelA);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.a.c
    public final void p(Bundle bundle) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.a.c.d(parcelA, bundle);
        b(18, parcelA);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.a.c
    public final void q(boolean z) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.a.c.b(parcelA, z);
        b(10, parcelA);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.a.c
    public final boolean r() throws RemoteException {
        Parcel parcelC = c(a());
        boolean zA = com.google.android.a.c.a(parcelC);
        parcelC.recycle();
        return zA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.libraries.a.c
    public final void s(Bundle bundle) throws RemoteException {
        Parcel parcelA = a();
        com.google.android.a.c.d(parcelA, bundle);
        b(20, parcelA);
    }
}
