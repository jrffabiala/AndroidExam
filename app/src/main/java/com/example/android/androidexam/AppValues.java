package com.example.android.androidexam;

import android.app.Application;

public class AppValues extends Application {
    private int topValue = 0;
    private int bottomValue = 0;

    public int unknown = (int) (100 * Math.random());

    public int getTopValue() {
        return topValue;
    }

    public void setTopValue(int topValue) {
        this.topValue = topValue;
    }

    public int getBottomValue() {
        return bottomValue;
    }

    public void setBottomValue(int bottomValue) {
        this.bottomValue = bottomValue;
    }
}
