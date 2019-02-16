package com.xwy.myapplication;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.xwy.myapplication.utils.DisplayUtils;
import com.xwy.myapplication.view.BarChartView;

public class MainActivity extends Activity implements View.OnClickListener{
    private BarChartView mView;
    private Button mPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mView = findViewById(R.id.boll_view);
        mPlay = findViewById(R.id.play_anim);
        mPlay.setOnClickListener(this);

        playAnim();
    }

    private void playAnim(){
//      playViewAnim();
        playValueAnim();
    }

    private void playValueAnim() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            //属性动画一定要满足两个条件才能起作用1.对象中必须要有设置该属性的setter方法2.在该set方法中必须要有ui的改变，否则无法体现
            ValueAnimator animator = ObjectAnimator.ofArgb(mView,"circleBackgroundColor",0xff000000,0xffffffff);
            animator.setEvaluator(new ArgbEvaluator());
            animator.setDuration(5000);
            animator.setRepeatMode(ValueAnimator.REVERSE);
            animator.start();
        }
    }

    private void playViewAnim(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.translate_anim);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //此处不要使用setAnimation，此方法只会让动画执行一次
        mView.startAnimation(animation);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play_anim:
                playAnim();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
