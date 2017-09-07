package com.hencoder.hencoderpracticedraw6.sample;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.hencoder.hencoderpracticedraw6.R;
import com.hencoder.hencoderpracticedraw6.Utils;

public class Sample06Duration extends LinearLayout {
    SeekBar durationSb;
    TextView durationValueTv;
    Button animateBt;
    ImageView imageView;

    int duration = 300;
    int translationState = 0;

    public Sample06Duration(Context context) {
        super(context);
    }

    public Sample06Duration(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample06Duration(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        durationSb = (SeekBar) findViewById(R.id.durationSb);
        durationValueTv = (TextView) findViewById(R.id.durationValueTv);
        durationValueTv.setText(getContext().getString(R.string.ms_with_value, duration));
        durationSb.setMax(10);
        durationSb.setProgress(1);
        durationSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                duration = progress * 300;
                durationValueTv.setText(getContext().getString(R.string.ms_with_value, duration));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (translationState) {
                    case 0:
                        imageView.animate().translationX(Utils.dpToPixel(100)).setDuration(duration);
                        break;
                    case 1:
                        imageView.animate().translationX(0).setDuration(duration);
                        break;
                }
                if (translationState < 1) {
                    translationState++;
                } else {
                    translationState = 0;
                }
            }
        });
    }
}
