package com.hencoder.hencoderpracticedraw6.sample;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw6.R;

public class Sample03Scale extends RelativeLayout {
    Button animateBt;
    ImageView imageView;

    int state = 0;

    public Sample03Scale(Context context) {
        super(context);
    }

    public Sample03Scale(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample03Scale(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                switch (state) {
                    case 0:
                        imageView.animate().scaleX(1.5f);
                        break;
                    case 1:
                        imageView.animate().scaleX(1);
                        break;
                    case 2:
                        imageView.animate().scaleY(.5f);
                        break;
                    case 3:
                        imageView.animate().scaleY(1);
                        break;
                }
                state++;
                if (state == 4) {
                    state = 0;
                }
            }
        });
    }
}