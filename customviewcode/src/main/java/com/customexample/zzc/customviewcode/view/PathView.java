package com.customexample.zzc.customviewcode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by tklc on 2018/5/9.
 */

public class PathView extends View {
    private Paint paint=new Paint();
    private int height,width;

    public PathView(Context context) {
        super(context);
        paint.setColor(Color.BLACK);           // 画笔颜色 - 黑色
        paint.setStyle(Paint.Style.STROKE);    // 填充模式 - 描边
        paint.setStrokeWidth(10);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.height=h;
        this.width=w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(width/2,height/2);
        Path path=new Path();
        path.lineTo(200,200);
        path.lineTo(200,0);
        path.close();
        canvas.drawPath(path,paint);


        Path path1 = new Path();
        path1.addRect(-200,-200,200,200, Path.Direction.CCW);
        path1.setLastPoint(-100,100);
        canvas.drawPath(path1,paint);
    }
}
