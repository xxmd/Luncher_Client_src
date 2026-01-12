package com.google.android.libraries.gsa.launcherclient;

/* compiled from: EventLogArray.java */
/* loaded from: launcher_client.jar:com/google/android/libraries/gsa/launcherclient/d.class */
final class d {
    public int a;
    public String b;
    public float c;
    public long d;
    public int e;

    private d() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a(int i, String str, float f) {
        this.a = i;
        this.b = str;
        this.c = f;
        this.d = System.currentTimeMillis();
        this.e = 0;
    }

    /* synthetic */ d(byte[] bArr) {
    }

    static /* synthetic */ void g(d dVar) {
        dVar.e++;
    }
}
