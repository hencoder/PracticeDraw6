package com.hencoder.hencoderpracticedraw6.sample.sample08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import static com.hencoder.hencoderpracticedraw6.Utils.dpToPixel;

public class Sample08ObjectAnimatorView extends View {
    final float radius = dpToPixel(80);

    float progress = 0;
    RectF arcRectF = new RectF();

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Sample08ObjectAnimatorView(Context context) {
        super(context);
    }

    public Sample08ObjectAnimatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample08ObjectAnimatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(dpToPixel(40));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float centerX = getWidth() / 2;
        float centerY = getHeight() / 2;

        paint.setColor(Color.parseColor("#E91E63"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(dpToPixel(15));
        arcRectF.set(centerX - radius, centerY - radius, centerX + radius, centerY + radius);
        canvas.drawArc(arcRectF, 135, progress * 2.7f, false, paint);

        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText((int) progress + "%", centerX, centerY - (paint.ascent() + paint.descent()) / 2, paint);
    }
}
