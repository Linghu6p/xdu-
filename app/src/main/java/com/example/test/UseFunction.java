package com.example.test;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

public class UseFunction {
    public void setColor(Drawable[] drawables, int color) {
        for (int i = 0, size = drawables.length; i < size; i++) {
            if (null != drawables[i]) {
                drawables[i].setColorFilter(
                        new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN));
            }
        }
    }
}
