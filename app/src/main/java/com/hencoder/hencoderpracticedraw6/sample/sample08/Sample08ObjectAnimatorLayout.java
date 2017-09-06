package com.hencoder.hencoderpracticedraw6.sample.sample08;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw6.R;

public class Sample08ObjectAnimatorLayout extends RelativeLayout {
    Sample08ObjectAnimatorView view;
    Button animateBt;

    public Sample08ObjectAnimatorLayout(Context context) {
        super(context);
    }

    public Sample08ObjectAnimatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample08ObjectAnimatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view = (Sample08ObjectAnimatorView) findViewById(R.id.objectAnimatorView);
        animateBt = (Button) findViewById(R.id.animateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(view, "progress", 0, 65);
                animator.setDuration(1000);
                animator.setInterpolator(new FastOutSlowInInterpolator());
                animator.start();
            }
        });
    }
}
