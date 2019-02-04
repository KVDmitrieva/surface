package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



public class DrawView extends SurfaceView implements SurfaceHolder.Callback {

   final SurfaceHolder surfaceHolder = getHolder();
    private volatile boolean running = true;

    public DrawView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    static Ball ball = new Ball();
    static Collect collect = new Collect();
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        new  Thread() {
            public void run(){
                while (running) {
                    Canvas canvas = surfaceHolder.lockCanvas();
                    if (canvas != null) {
                        try {
                            canvas.drawColor(Color.BLACK);
                            ball.onDraw(canvas);
                            collect.onDraw(canvas);
                            ball.update();

                        } finally {
                            surfaceHolder.unlockCanvasAndPost(canvas);
                        }
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ball.setVec(event);
        return super.onTouchEvent(event);
    }
    }
