package com.mistcorp.testanimation;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle; import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {
    private ImageButton buttonA;
    private Button startTransformAnim;
    private Button cancelAnim;
    private ImageView animationView;
    int count;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonA = (ImageButton) findViewById(R.id.button4);
        startTransformAnim= (Button) findViewById(R.id.transformAnimationStart);
        cancelAnim = (Button) findViewById(R.id.cancelAnimation);
        animationView = (ImageView) findViewById(R.id.animationView);

        //startFrameAnim.setOnClickListener(this);
        buttonA.setBackgroundResource(R.drawable.ic_launcher);
        startTransformAnim.setOnClickListener(this);
        cancelAnim.setOnClickListener(this);
        count = 0;
    }

    public void onClick(View v) {
        /*if (startFrameAnim.equals(v)) {
        //animationView.setBackgroundResource(R.anim.frame_anim);
        AnimationDrawable animation = (AnimationDrawable) animationView.getBackground();
        animation.start();*/
    if (startTransformAnim.equals(v)) {
        animationView.setBackgroundResource(R.mipmap.ic_launcher);
        Animation transformAnimation = AnimationUtils.loadAnimation(this, R.anim.transform_anim);
        animationView.startAnimation(transformAnimation);
    } else if (cancelAnim.equals(v)) {
        animationView.setBackgroundColor(Color.BLACK);

    }
    }

    public void onClickButton(View view) {
        if(count == 0) {
            buttonA.setBackgroundResource(R.drawable.ic_launcher);
            RotateAnimation animation = new RotateAnimation(0, 360, 150, 150);
            animation.setRepeatMode(Animation.ABSOLUTE);
            animation.setRepeatCount(Animation.INFINITE);
            animation.setInterpolator(new LinearInterpolator());
            animation.setDuration(1000L);

            view.startAnimation(animation);
            count = 1;
        }
        else {
            view.clearAnimation();
            count = 0;
        }
    }
}