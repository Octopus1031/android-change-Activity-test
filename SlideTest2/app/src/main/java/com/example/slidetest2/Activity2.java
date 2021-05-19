package com.example.slidetest2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView tv;
    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        tv = (TextView)findViewById(R.id.textView);

        gestureDetector= new GestureDetector(this, new OnGestureListener(){
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }
            @Override
            public void onShowPress(MotionEvent e) {
            }
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }
            @Override
            public void onLongPress(MotionEvent e) {
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2,float velocityX, float velocityY) {
                if(e1.getRawX()-e2.getRawX()>200){
                }
                else if(e2.getRawX()-e1.getRawX()>200){
                    flingR();
                }
                return true;
            }
        });
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        boolean onTouchEvent = gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
    public void flingR(){
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.out_right_anim, R.anim.in_left_anim);
        finish();
    }
}