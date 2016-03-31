package com.jash.customviewdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

/**
 * Created by jash on 16-3-28.
 */
public class ClockView extends View implements Handler.Callback{
    private Paint paint;
    private Handler handler = new Handler(this);
    private Bitmap bitmap;
    private BitmapShader shader;

    public ClockView(Context context) {
        this(context, null);
    }

    public ClockView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        handler.sendEmptyMessage(0);
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.paper);
        shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        float min = Math.min(getWidth() / 200.0f, getHeight() / 200.0f);
        canvas.scale(min, min);
        canvas.drawColor(Color.WHITE);
        canvas.save();
        Paint temp = new Paint();
        temp.setShader(shader);
        canvas.translate(-100, -100);
        canvas.drawCircle(100, 100, 100, temp);
        canvas.restore();
        this.paint.setStrokeWidth(5);
        this.paint.setColor(Color.BLACK);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setAntiAlias(true);
        canvas.drawCircle(0, 0, 100, this.paint);
        canvas.save();
        for (int i = 0; i < 12; i++) {
            if (i % 3 == 0) {
                this.paint.setStrokeWidth(7);
                canvas.drawLine(0, -100, 0, -85, this.paint);
            } else {
                this.paint.setStrokeWidth(5);
                canvas.drawLine(0, -100, 0, -90, this.paint);
            }
            canvas.rotate(30, 0, 0);
        }
        canvas.restore();
        Calendar calendar = Calendar.getInstance();
        canvas.save();
        this.paint.setStrokeWidth(3);
        this.paint.setColor(Color.RED);
        canvas.rotate(calendar.get(Calendar.SECOND) * 6, 0, 0);
        canvas.drawLine(0, 10, 0, -90, this.paint);
        canvas.restore();
        canvas.restore();
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                //同步刷新通知,优点是快,缺点是只能在主线程调用
                invalidate();
                //异步刷新通知,优点是可以在子线程中调用,缺点是慢
//                postInvalidate();
                handler.sendEmptyMessageDelayed(0, 500);
                break;
        }
        return true;
    }
}
