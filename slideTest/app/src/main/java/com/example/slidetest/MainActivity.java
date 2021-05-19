package com.example.slidetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.*;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    GestureDetector gestureDetector;
    Fra1 fra1 = new Fra1();
    Fra2 fra2 = new Fra2();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl, fra1).commit();

        text1 = (TextView)findViewById(R.id.text1);

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
                    flingL();
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
    public void flingL(){
        text1.setText("向左滑");
        getSupportFragmentManager().beginTransaction().setCustomAnimations(
                R.anim.in_right_anim,
                R.anim.out_left_anim,
                R.anim.in_left_anim,
                R.anim.out_right_anim
        ).replace(R.id.fl,fra2).commit();
    }
    public void flingR(){
        text1.setText("向右滑");
        getSupportFragmentManager().beginTransaction().setCustomAnimations(
                R.anim.in_left_anim,
                R.anim.out_right_anim,
                R.anim.in_right_anim,
                R.anim.out_left_anim
        ).replace(R.id.fl,fra1).commit();
    }
}