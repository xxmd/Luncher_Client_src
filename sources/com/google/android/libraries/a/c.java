package com.google.android.libraries.a;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.WindowManager;

/* compiled from: ILauncherOverlay.java */
/* loaded from: launcher_client.jar:com/google/android/libraries/a/c.class */
public interface c extends IInterface {
    void d() throws RemoteException;

    void e(float f) throws RemoteException;

    void f() throws RemoteException;

    void g(WindowManager.LayoutParams layoutParams, e eVar, int i) throws RemoteException;

    void h(Bundle bundle, e eVar) throws RemoteException;

    void i(boolean z) throws RemoteException;

    void j(int i) throws RemoteException;

    void k(Bundle bundle) throws RemoteException;

    void l() throws RemoteException;

    void m() throws RemoteException;

    void n(int i) throws RemoteException;

    void o(int i) throws RemoteException;

    void p(Bundle bundle) throws RemoteException;

    void q(boolean z) throws RemoteException;

    boolean r() throws RemoteException;

    void s(Bundle bundle) throws RemoteException;
}
