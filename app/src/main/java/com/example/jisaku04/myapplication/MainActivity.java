package com.example.jisaku04.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.graphics.*;
import android.content.*;


public class MainActivity extends AppCompatActivity {

    SampleView sv;
    TextView tv1, tv2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        setContentView(ll);
        tv1 = new TextView(this);
        tv2 = new TextView(this);
        tv1.setBackgroundColor(Color.GRAY);
        tv2.setBackgroundColor(Color.GRAY);
        sv = new SampleView(this);
        sv.setBackgroundColor(Color.GREEN);

        ll.addView(tv1);
        ll.addView(tv2);
        ll.addView(sv);
    }

    class SampleView extends View{
        float x, y;
        Paint p;
        public SampleView(Context cn){
            super(cn);
            x = -50;
            y = -50;
            p = new Paint();
        }
        public boolean onTouchEvent(MotionEvent e){
            x = e.getX();
            y = e.getY();
            this.invalidate();
            if(x < 0)   x = 0;
            if(y < 0)   y = 0;
            String i = "X座標：" + String.valueOf((int)x);
            String j = "Y座標：" + String.valueOf((int)y);
            tv1.setText(i);
            tv2.setText(j);

            return true;
        }
        protected void onDraw(Canvas cs){
            super.onDraw(cs);
            p.setColor(Color.RED);
            p.setStyle(Paint.Style.FILL);
            cs.drawCircle(x,y,50,p);
        }

    }
}
