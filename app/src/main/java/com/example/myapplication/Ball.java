package com.example.myapplication;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;


import static com.example.myapplication.DrawView.ball;
import static com.example.myapplication.DrawView.collect;

public class Ball {
    float x = 20, y=20, rad = 50;
    private float vX = 0;
    private float vY = 0;
    private float velocity = 3;
    int rand=(int)(Math.random()*5);

    void bigger(){
        rad=rad+10;
    }


    void setcol(Paint paint){
        switch (rand) {
            case 1:
                paint.setColor(Color.RED);
                break;
            case 2:
                paint.setColor(Color.BLUE);
                break;
            case 3:
                paint.setColor(Color.GREEN);
                break;
            case 4:
                paint.setColor(Color.YELLOW);
                break;
            default:
                paint.setColor(Color.MAGENTA);
        }
    }
    void setVec(MotionEvent event){
        float corX = event.getX();
        float corY = event.getY();
        float vx = corX-x;
        float vy =corY-y;
        float len = (float)Math.sqrt(vx*vx+vy*vy);
        vX = vx/len;
        vY = vy/len;
        if (corX<x+rad && corX>x-rad && corY<y+rad && corY>y-rad) bigger();
    }



    private int rand(){
        int rand=(int)(Math.random()*10);
        return rand;}
    public void update(){
        x += vX * velocity;
        y += vY * velocity;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        float a = ball.x+ball.rad;
        float b = ball.x-ball.rad;
        float c = ball.y+ball.rad;
        float d = ball.y-ball.rad;
        float a1 = collect.vX+30;
        float b1 = collect.vX-30;
        float c1 = collect.vY+30;
        float d1 = collect.vY-30;
        if (b<=b1&&b1<=a&&d<=c1&&c1<=c||b<=b1&&b1<=a&&d<=d1&&d1<=c||b<=a1&&a1<=a&&d<=c1&&c1<=c||b<=a1&&a1<=a&&d<=d1&&d1<=c){
            ball.bigger();
            collect.vX = 1000/rand();
            collect.vY = 1000/rand();
            collect.col=rand()/2;
        }
    }
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        setcol(paint);
        canvas.drawCircle(x,y,rad,paint);
    }
}
