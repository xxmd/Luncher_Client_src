package com.google.android.libraries.gsa.launcherclient;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import android.view.WindowManager;
import java.io.PrintWriter;

/* loaded from: launcher_client.jar:com/google/android/libraries/gsa/launcherclient/LauncherClient.class */
public class LauncherClient {
    public static int b = -1;
    public final Activity c;
    public final LauncherClientCallbacks d;
    public final Handler e;
    public final e f;
    public final e g;
    public final l h;
    public final c i;
    public final BroadcastReceiver j;
    protected com.google.android.libraries.a.c a;
    public int k;
    public boolean l;
    public int m;
    public ClientOptions n;
    public WindowManager.LayoutParams o;
    public i p;

    /* loaded from: launcher_client.jar:com/google/android/libraries/gsa/launcherclient/LauncherClient$ClientOptions.class */
    public static class ClientOptions {
        public final int a;
        public String b;
        public final Bitmap c;
        public final boolean d;
        public final String e;

        private ClientOptions(String str, Bitmap bitmap, boolean z) {
            this.b = "com.google.android.googlequicksearchbox";
            this.a = 7;
            this.c = bitmap;
            this.d = z;
            this.e = str;
        }

        public ClientOptions(boolean z, boolean z2, boolean z3) {
            this.b = "com.google.android.googlequicksearchbox";
            this.a = (z ? 1 : 0) | (true != z2 ? 0 : 2) | (true != z3 ? 0 : 4);
            this.c = null;
            this.e = "";
            this.d = false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static ClientOptions createForSharedOverlay(String str, Bitmap bitmap, boolean z) {
            return new ClientOptions(str, bitmap, z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public LauncherClient(Activity activity) {
        this(activity, new LauncherClientCallbacksAdapter());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void onAttachedToWindow() {
        if (this.l) {
            return;
        }
        this.f.a("attachedToWindow");
        o(this.c.getWindow().getAttributes());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void onDetachedFromWindow() {
        if (this.l) {
            return;
        }
        this.f.a("detachedFromWindow");
        o(null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void onResume() {
        if (this.l) {
            return;
        }
        this.k |= 2;
        if (this.a != null && this.o != null) {
            try {
                if (b < 4) {
                    this.a.m();
                } else {
                    this.a.n(this.k);
                }
            } catch (RemoteException unused) {
            }
        }
        this.f.b("stateChanged ", this.k);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void onPause() {
        if (this.l) {
            return;
        }
        this.k &= -3;
        if (this.a != null && this.o != null) {
            try {
                if (b < 4) {
                    this.a.l();
                } else {
                    this.a.n(this.k);
                }
            } catch (RemoteException unused) {
            }
        }
        this.f.b("stateChanged ", this.k);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void onStart() {
        if (this.l) {
            return;
        }
        this.i.c(false);
        reconnect();
        int i = this.k | 1;
        this.k = i;
        com.google.android.libraries.a.c cVar = this.a;
        if (cVar != null && this.o != null) {
            try {
                cVar.n(i);
            } catch (RemoteException unused) {
            }
        }
        this.f.b("stateChanged ", this.k);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void onStop() {
        if (this.l) {
            return;
        }
        this.i.c(true);
        this.h.e();
        int i = this.k & (-2);
        this.k = i;
        com.google.android.libraries.a.c cVar = this.a;
        if (cVar != null && this.o != null) {
            try {
                cVar.n(i);
            } catch (RemoteException unused) {
            }
        }
        this.f.b("stateChanged ", this.k);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void onDestroy() {
        n(!this.c.isChangingConfigurations());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void disconnect() {
        n(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setClientOptions(ClientOptions clientOptions) {
        if (this.n.a != clientOptions.a) {
            this.n = clientOptions;
            if (this.o != null) {
                p();
            }
            e eVar = this.f;
            int i = this.n.a;
            StringBuilder sb = new StringBuilder(28);
            sb.append("setClientOptions ");
            sb.append(i);
            eVar.a(sb.toString());
            return;
        }
        if (b < 10 || this.n.c == null || clientOptions.c == null) {
            return;
        }
        try {
            this.n = clientOptions;
            if (this.a == null) {
                Log.d("DrawerOverlayClient", "updateClientOptions not called since the overlay has not yet attached");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("partner_overlay_icon", this.n.c);
            bundle.putString("partner_overlay_product_name", this.n.e);
            bundle.putBoolean("google_overlay_is_default", this.n.d);
            this.a.s(bundle);
            this.f.a("updateClientOptions");
        } catch (RemoteException e) {
            Log.e("DrawerOverlayClient", "updateClientOptions() to set partner overlay icon failed", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void updatePartnerOverlayIcon(Bitmap bitmap) {
        setClientOptions(ClientOptions.createForSharedOverlay(this.n.e, bitmap, this.n.d));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void reconnect() {
        if (this.l) {
            return;
        }
        com.google.android.libraries.gsa.launcherclient.l.i(this.e, new h(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void startMove() {
        this.f.a("startMove");
        if (q()) {
            try {
                this.a.d();
            } catch (RemoteException unused) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void endMove() {
        this.f.a("endMove");
        if (q()) {
            try {
                this.a.f();
            } catch (RemoteException unused) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void updateMove(float f) {
        this.f.c("updateMove", f);
        if (q()) {
            try {
                this.a.e(f);
            } catch (RemoteException unused) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void hideOverlay(int i) {
        int iR = r(i);
        this.f.b("hideOverlay", i);
        com.google.android.libraries.a.c cVar = this.a;
        if (cVar != null) {
            try {
                cVar.j(iR);
            } catch (RemoteException unused) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void showOverlay(int i) {
        int iR = r(i);
        this.f.b("showOverlay", i);
        com.google.android.libraries.a.c cVar = this.a;
        if (cVar != null) {
            try {
                cVar.o(iR);
            } catch (RemoteException unused) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void requestHotwordDetection(boolean z) {
        this.f.d("requestHotwordDetection", z);
        com.google.android.libraries.a.c cVar = this.a;
        if (cVar != null) {
            try {
                cVar.q(z);
            } catch (RemoteException unused) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void reattachOverlay() {
        this.f.a("reattachOverlay");
        if (this.o == null || b < 7) {
            return;
        }
        p();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void dump(String str, PrintWriter printWriter) {
        printWriter.println(String.valueOf(str).concat("LauncherClient"));
        String strConcat = String.valueOf(str).concat("  ");
        boolean zQ = q();
        StringBuilder sb = new StringBuilder(String.valueOf(strConcat).length() + 18);
        sb.append(strConcat);
        sb.append("isConnected: ");
        sb.append(zQ);
        printWriter.println(sb.toString());
        boolean zG = this.h.g();
        StringBuilder sb2 = new StringBuilder(String.valueOf(strConcat).length() + 18);
        sb2.append(strConcat);
        sb2.append("act.isBound: ");
        sb2.append(zG);
        printWriter.println(sb2.toString());
        boolean zG2 = this.i.g();
        StringBuilder sb3 = new StringBuilder(String.valueOf(strConcat).length() + 18);
        sb3.append(strConcat);
        sb3.append("app.isBound: ");
        sb3.append(zG2);
        printWriter.println(sb3.toString());
        int i = b;
        StringBuilder sb4 = new StringBuilder(String.valueOf(strConcat).length() + 27);
        sb4.append(strConcat);
        sb4.append("serviceVersion: ");
        sb4.append(i);
        printWriter.println(sb4.toString());
        StringBuilder sb5 = new StringBuilder(String.valueOf(strConcat).length() + 17);
        sb5.append(strConcat);
        sb5.append("clientVersion: ");
        sb5.append(19);
        printWriter.println(sb5.toString());
        boolean z = this.n.d;
        StringBuilder sb6 = new StringBuilder(String.valueOf(strConcat).length() + 29);
        sb6.append(strConcat);
        sb6.append("isGoogleOverlayDefault: ");
        sb6.append(z);
        printWriter.println(sb6.toString());
        String str2 = this.n.e;
        StringBuilder sb7 = new StringBuilder(String.valueOf(strConcat).length() + 27 + String.valueOf(str2).length());
        sb7.append(strConcat);
        sb7.append("partnerOverlayProductName: ");
        sb7.append(str2);
        printWriter.println(sb7.toString());
        boolean z2 = this.n.c != null;
        StringBuilder sb8 = new StringBuilder(String.valueOf(strConcat).length() + 34);
        sb8.append(strConcat);
        sb8.append("isPartnerOverlayIconPresent: ");
        sb8.append(z2);
        printWriter.println(sb8.toString());
        int i2 = this.k;
        StringBuilder sb9 = new StringBuilder(String.valueOf(strConcat).length() + 27);
        sb9.append(strConcat);
        sb9.append("mActivityState: ");
        sb9.append(i2);
        printWriter.println(sb9.toString());
        int i3 = this.m;
        StringBuilder sb10 = new StringBuilder(String.valueOf(strConcat).length() + 27);
        sb10.append(strConcat);
        sb10.append("mServiceStatus: ");
        sb10.append(i3);
        printWriter.println(sb10.toString());
        int i4 = this.n.a;
        StringBuilder sb11 = new StringBuilder(String.valueOf(strConcat).length() + 45);
        sb11.append(strConcat);
        sb11.append("mCurrentServiceConnectionOptions: ");
        sb11.append(i4);
        printWriter.println(sb11.toString());
        this.f.e(strConcat, printWriter);
        this.g.e(strConcat, printWriter);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void n(boolean z) {
        if (!this.l) {
            this.c.unregisterReceiver(this.j);
        }
        this.l = true;
        this.h.e();
        i iVar = this.p;
        if (iVar != null) {
            iVar.c();
            this.p = null;
        }
        this.i.d(this, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void o(WindowManager.LayoutParams layoutParams) {
        if (this.o == layoutParams) {
            return;
        }
        this.o = layoutParams;
        if (this.o != null) {
            p();
            return;
        }
        com.google.android.libraries.a.c cVar = this.a;
        if (cVar != null) {
            try {
                cVar.i(this.c.isChangingConfigurations());
            } catch (RemoteException unused) {
            }
            this.a = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void p() {
        if (this.a != null) {
            try {
                if (this.p == null) {
                    this.p = new i();
                }
                this.p.b(this);
                if (b < 3) {
                    this.a.g(this.o, this.p, this.n.a);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("layout_params", this.o);
                    bundle.putParcelable("configuration", this.c.getResources().getConfiguration());
                    bundle.putInt("client_options", this.n.a);
                    if (this.n.c != null) {
                        bundle.putParcelable("partner_overlay_icon", this.n.c);
                        bundle.putBoolean("google_overlay_is_default", this.n.d);
                        bundle.putString("partner_overlay_product_name", this.n.e);
                    }
                    this.a.h(bundle, this.p);
                }
                if (b >= 4) {
                    this.a.n(this.k);
                } else if ((this.k & 2) != 0) {
                    this.a.m();
                } else {
                    this.a.l();
                }
            } catch (RemoteException unused) {
            }
        }
    }

    private final boolean q() {
        return this.a != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int r(int i) {
        if (i <= 0 || i > 2047) {
            throw new IllegalArgumentException("Invalid duration");
        }
        return (i << 2) | 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    final void a(com.google.android.libraries.a.c cVar) {
        this.g.d("Connected", cVar != null);
        this.a = cVar;
        if (this.a == null) {
            s(0);
        } else if (this.o != null) {
            p();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s(int i) {
        if (this.m != i) {
            this.m = i;
            int i2 = i & 1;
            this.d.onServiceStateChanged(1 == i2, (i & 2) != 0);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static Intent b(Context context, String str) {
        String packageName = context.getPackageName();
        int iMyUid = Process.myUid();
        StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 18);
        sb.append("app://");
        sb.append(packageName);
        sb.append(":");
        sb.append(iMyUid);
        return new Intent("com.android.launcher3.WINDOW_OVERLAY").setPackage(str).setData(Uri.parse(sb.toString()).buildUpon().appendQueryParameter("v", Integer.toString(10)).appendQueryParameter("cv", Integer.toString(19)).build());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t(Context context) {
        ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(b(context, this.n.b), 128);
        if (resolveInfoResolveService == null || resolveInfoResolveService.serviceInfo.metaData == null) {
            b = 1;
        } else {
            b = resolveInfoResolveService.serviceInfo.metaData.getInt("service.api.version", 1);
        }
    }

    static /* synthetic */ void l(LauncherClient launcherClient, Bundle bundle) {
        LauncherClientCallbacks launcherClientCallbacks = launcherClient.d;
        if (launcherClientCallbacks instanceof SharedOverlayCallbacks) {
            SharedOverlayCallbacks sharedOverlayCallbacks = (SharedOverlayCallbacks) launcherClientCallbacks;
            if (bundle.containsKey("minus_one_thumbnail_image_960_540") && bundle.containsKey("minus_one_product_name")) {
                sharedOverlayCallbacks.onGoogleOverlayBannerChanged(bundle.getString("minus_one_product_name"), (Icon) bundle.getParcelable("minus_one_thumbnail_image_960_540"));
            }
            if (bundle.getBoolean("overlay_animation_complete")) {
                sharedOverlayCallbacks.onGoogleOverlayTransitionComplete();
            }
            Bitmap bitmap = (Bitmap) bundle.getParcelable("google_overlay_icon");
            if (bitmap != null) {
                sharedOverlayCallbacks.onGoogleOverlayIconChanged(bitmap);
            }
            if (bundle.getBoolean("initiate_overlay_switch")) {
                sharedOverlayCallbacks.onSharedOverlaySwitchInitiated();
            }
        }
        int i = bundle.getInt("service_status", -1);
        if (i != -1) {
            launcherClient.s(i);
        }
        LauncherClientCallbacks launcherClientCallbacks2 = launcherClient.d;
        if (launcherClientCallbacks2 instanceof j) {
            ((j) launcherClientCallbacks2).a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 2 */
    public LauncherClient(Activity activity, LauncherClientCallbacks launcherClientCallbacks) {
        this(activity, launcherClientCallbacks, new ClientOptions(true, true, true));
    }

    public LauncherClient(Activity activity, LauncherClientCallbacks launcherClientCallbacks, ClientOptions clientOptions) {
        this(activity, launcherClientCallbacks, clientOptions, Looper.getMainLooper());
    }

    public LauncherClient(Activity activity, LauncherClientCallbacks launcherClientCallbacks, ClientOptions clientOptions, Looper looper) {
        this.f = new e("Client", 20);
        this.g = new e("Service", 10);
        this.j = new f(this);
        this.k = 0;
        this.l = false;
        this.m = 0;
        this.c = activity;
        this.d = launcherClientCallbacks;
        this.n = clientOptions;
        this.e = new Handler(looper);
        this.h = new l(activity, 65, this.e, this.n.b);
        this.i = com.google.android.libraries.gsa.launcherclient.c.a(activity, this.e, this.n.b);
        this.a = this.i.b(this);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        if (Build.VERSION.SDK_INT >= 19) {
            intentFilter.addDataSchemeSpecificPart(this.n.b, 0);
        }
        this.c.registerReceiver(this.j, intentFilter);
        if (b <= 0) {
            t(activity);
        }
        reconnect();
        if (Build.VERSION.SDK_INT < 19 || this.c.getWindow() == null || this.c.getWindow().peekDecorView() == null || !this.c.getWindow().peekDecorView().isAttachedToWindow()) {
            return;
        }
        onAttachedToWindow();
    }

    public void hideOverlay(AnimationType animationType, int i) {
        if (b < 10) {
            hideOverlay(i);
        }
        e eVar = this.f;
        String strValueOf = String.valueOf(animationType);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 15);
        sb.append("hideOverlay: ");
        sb.append(strValueOf);
        sb.append(", ");
        eVar.b(sb.toString(), i);
        if (this.a != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("overlay_animation_type", animationType.a());
            bundle.putInt("overlay_animation_duration", i);
            try {
                this.a.k(bundle);
            } catch (RemoteException e) {
                Log.d("DrawerOverlayClient", "Unable to close overlay", e);
            }
        }
    }

    public void showOverlay(AnimationType animationType, int i) {
        if (b < 10) {
            showOverlay(i);
        }
        e eVar = this.f;
        String strValueOf = String.valueOf(animationType);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 15);
        sb.append("showOverlay: ");
        sb.append(strValueOf);
        sb.append(", ");
        eVar.b(sb.toString(), i);
        if (this.a != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("overlay_animation_type", animationType.a());
            bundle.putInt("overlay_animation_duration", i);
            try {
                this.a.p(bundle);
            } catch (RemoteException e) {
                Log.d("DrawerOverlayClient", "Unable to show overlay", e);
            }
        }
    }

    public void hideOverlay(boolean z) {
        this.f.d("hideOverlay", z);
        com.google.android.libraries.a.c cVar = this.a;
        if (cVar != null) {
            try {
                cVar.j(z ? 1 : 0);
            } catch (RemoteException unused) {
            }
        }
    }

    public void showOverlay(boolean z) {
        this.f.d("showOverlay", z);
        com.google.android.libraries.a.c cVar = this.a;
        if (cVar != null) {
            try {
                cVar.o(z ? 1 : 0);
            } catch (RemoteException unused) {
            }
        }
    }
}
