package com.google.android.libraries.gsa.launcherclient;

public enum AnimationType {
    NONE(0),
    SLIDE(1),
    FADE(3);

    private final int a;

    AnimationType(int a) {
        this.a = a;
    }

    public int a() {
        return a;
    }
}
