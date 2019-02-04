package com.example.myapplication;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Collect {
    public float vX=500, vY=500;
    float rad = 30;

    private int rand(){
        int rand=(int)(Math.random()*5);
        return rand;}

    int col = rand();
    void setcol(Paint paint){
        switch (col) {
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

    protected void onDraw(Canvas canvas) {
        rad =30;
        Paint paint = new Paint();
        setcol(paint);
        canvas.drawCircle(vX,vY,rad,paint);
    }

}
