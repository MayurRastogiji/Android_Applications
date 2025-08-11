package com.example.bussafe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class AttendanceBar extends View {

    private Paint paint;
    private float progress = 0f;

    public AttendanceBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public AttendanceBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AttendanceBar(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
    }

    public void setProgress(int percentage) {
        progress = percentage;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float width = getWidth();
        float height = getHeight();

        paint.setColor(Color.LTGRAY);
        canvas.drawRect(0, 0, width, height, paint);

        paint.setColor(Color.BLUE);
        float progressWidth = (progress / 100) * width;
        canvas.drawRect(0, 0, progressWidth, height, paint);
    }
}