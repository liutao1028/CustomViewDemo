package com.jash.customviewdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by jash on 16-3-28.
 */
public class CustomView extends View {
    private Paint paint;
    private Bitmap bitmap;

    /**
     * 在java文件当中使用
     * @param context
     */
    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * 在XML中使用
     * @param context 加载资源文件使用
     * @param attrs xml中的属性
     * @param defStyleAttr 默认样式
     */
    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.role);

    }

    /**
     * 绘制
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        paint.setColor(Color.BLACK);
        //笔的粗细
        paint.setStrokeWidth(10);
        //画点.正方形
        canvas.drawPoint(100, 100, paint);
        canvas.drawLine(200, 200, 400, 400, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(200, 500, 600, 700, paint);
        canvas.drawCircle(500, 500, 300, paint);
//        canvas.drawOval(new RectF(200, 500, 600, 700), paint);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(new RectF(200, 700, 600, 1100), 30, 90, false, paint);
        Path path = new Path();
        canvas.drawColor(Color.WHITE);
//        path.moveTo(100, 100);
//        path.lineTo(200, 200);
//        path.lineTo(100, 200);
//        paint.setStyle(Paint.Style.FILL);
//        canvas.drawPath(path, paint);
        int cx = 500, cy = 500, radius = 300;
        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawCircle(cx, cy, radius, paint);
//        path.moveTo(cx, cy - radius);
//        int ang = 8;
//        for (int i = 1; i <= ang; i++) {
//            path.lineTo(
//                    cx + (float)Math.sin(Math.toRadians(i * 360 / ang)) * radius,
//                    cy - (float)Math.cos(Math.toRadians(i * 360 / ang)) * radius);
//        }
//        path.moveTo(100, 100);
//        path.arcTo(new RectF(100, 100, 200, 200), 0, 90, true);
//        path.lineTo(100, 100);
//        canvas.drawPath(path, paint);
        paint.setStyle(Paint.Style.STROKE   );
        canvas.drawRect(100, 200, 700, 400, paint);
        paint.setTextSize(100);
        Paint.FontMetrics metrics = paint.getFontMetrics();
        canvas.drawText("中文测试", 100, 400 - metrics.bottom, paint);
//        paint.setColor(Color.RED);
//        canvas.drawLine(100, 200, 800, 200, paint);

//        paint.setColor(Color.GREEN);
//        canvas.drawLine(100, 200 + metrics.top, 800, 200 + metrics.top, paint);
//        paint.setColor(Color.BLACK);
//        canvas.drawLine(100, 200 + metrics.ascent, 800, 200 + metrics.ascent, paint);
//        paint.setColor(Color.YELLOW);
//        canvas.drawLine(100, 200 + metrics.leading, 800, 200 + metrics.leading, paint);
//        paint.setColor(Color.BLUE);
//        canvas.drawLine(100, 200 + metrics.descent, 800, 200 + metrics.descent, paint);
//        paint.setColor(Color.GRAY);
//        canvas.drawLine(100, 200 + metrics.bottom, 800, 200 + metrics.bottom, paint);
        canvas.drawColor(Color.WHITE);
//        canvas.drawBitmap(bitmap, 100, 100, paint);
//        canvas.drawBitmap(bitmap,
//                new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()),
//                new Rect(0, 0, getWidth(), getHeight() / 2),
//                paint);
//        canvas.drawBitmap(bitmap,
//                new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight() / 2),
//                new Rect(0, getHeight() / 2, getWidth(), getHeight()),
//                paint);
        Matrix matrix = new Matrix();
//        matrix.setTranslate(100, 100);
//        matrix.preTranslate(100, 100);
//        matrix.postTranslate(100, 100);
//        matrix.preRotate(45, 0, 0);
//        matrix.preTranslate(100, 100);
//        matrix.setTranslate(100, 100);
//        matrix.setScale(2, 0.5f);
//        matrix.setSkew(0.5f, 0);
//        matrix.setRotate(180, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
//        matrix.setScale(1, -1, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
//        canvas.drawBitmap(bitmap, matrix, paint);
//        paint.setAntiAlias(true);
//        LinearGradient linearGradient = new LinearGradient(100, 100, 500, 100, Color.RED, Color.BLUE, Shader.TileMode.REPEAT);
        LinearGradient linearGradient = new LinearGradient(100, 100, 500, 300,
                new int[]{0xffff0000,0xffff8800,0xffffff00,0xff00ff00,0xff00ffff,0xff0000ff,0xffff00ff},
                new float[]{0, 1.0f / 6, 2.0f / 6, 3.0f / 6, 4.0f / 6, 5.0f / 6, 1},
                Shader.TileMode.REPEAT);
        paint.setShader(linearGradient);
        paint.setStyle(Paint.Style.FILL);
//        RadialGradient radialGradient = new RadialGradient(300, 200, 100, Color.RED, Color.BLUE, Shader.TileMode.MIRROR);
        RadialGradient radialGradient = new RadialGradient(300, 200, 100,
                new int[]{0xffff0000,0xffff8800,0xffffff00,0xff00ff00,0xff00ffff,0xff0000ff,0xffff00ff},
                new float[]{0, 1.0f / 6, 2.0f / 6, 3.0f / 6, 4.0f / 6, 5.0f / 6, 1},
                Shader.TileMode.MIRROR);
        paint.setShader(radialGradient);
//        SweepGradient sweepGradient = new SweepGradient(getWidth() / 2, getHeight() / 2, Color.RED, Color.BLUE);
        SweepGradient sweepGradient = new SweepGradient(getWidth() / 2, getHeight() / 2,
                new int[]{0xffff0000,0xffff8800,0xffffff00,0xff00ff00,0xff00ffff,0xff0000ff,0xffff00ff},
                new float[]{0, 1.0f / 6, 2.0f / 6, 3.0f / 6, 4.0f / 6, 5.0f / 6, 1}
        );
        paint.setShader(sweepGradient);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
        paint.setShader(bitmapShader);
//        canvas.drawRect(0, 0, 500, 500, paint);
        int temp = bitmap.getWidth() / 2;
//        paint.setAntiAlias(true);
        //保存当前矩阵
        canvas.save();
        //保存什么内容
//        canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.translate(500 - temp, 500 - temp);
        canvas.drawRect(0, 0, 100, 100,paint);
        //恢复上一次保存的矩阵
        canvas.restore();
        //恢复前几次的.
//        canvas.restoreToCount(3);
//        canvas.drawCircle(temp, temp, temp, paint);
//        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 500, paint);
//        canvas.drawText("多彩文字", 100, 200, paint);

    }

    /**
     * 测量
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 触摸
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
