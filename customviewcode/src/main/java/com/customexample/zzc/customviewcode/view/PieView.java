package com.customexample.zzc.customviewcode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.customexample.zzc.customviewcode.entity.PieData;

import java.util.ArrayList;

/**
 * Created by tklc on 2018/4/27.
 */

/**
 * 步骤	关键字	作用
 1	构造函数	初始化(初始化画笔Paint)
 2	onMeasure	测量View的大小(暂时不用关心)
 3	onSizeChanged	确定View大小(记录当前View的宽高)
 4	onLayout	确定子View布局(无子View，不关心)
 5	onDraw	实际绘制内容(绘制饼状图)
 6	提供接口	提供接口(提供设置数据的接口)
 */
public class PieView extends View {
    // 颜色表(注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    // 饼状图初始绘制角度
    private float mStartAngle = 0;
    //初始化画笔
    private Paint paint=new Paint();
    //数据
    private ArrayList<PieData> pieDataArrayList;
    //宽高
    private int height,width;

    public PieView(Context context) {
        super(context);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width=w;
        height=h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (pieDataArrayList==null) return;
        float currentAngle=mStartAngle;//当前起始角度
        canvas.translate(width/2,height/2);// 将画布坐标原点移动到中心位置
        float r= (float) (Math.min(width,height)*0.4);
        RectF rectF=new RectF(-r,-r,r,r);

        for (int i = 0; i < pieDataArrayList.size(); i++) {
            PieData pieData=pieDataArrayList.get(i);
            paint.setColor(pieData.getColor());
            canvas.drawArc(rectF,currentAngle,pieData.getAngle(),true,paint);
            currentAngle+=pieData.getAngle();
        }

    }
    //提供接口	提供接口(提供设置数据的接口)
    public void setmStartAngle(float mStartAngle){
        this.mStartAngle=mStartAngle;
        invalidate();//刷新
    }
    public void setData(ArrayList<PieData> pieDataArrayList){
        this.pieDataArrayList=pieDataArrayList;
        initData(pieDataArrayList);
        invalidate();
    }

    private void initData(ArrayList<PieData> pieDataArrayList) {
        if (pieDataArrayList==null||pieDataArrayList.size()==0) return;
        float sumValue=0;
        for (int i = 0; i < pieDataArrayList.size(); i++) {
            PieData pieData=pieDataArrayList.get(i);
            sumValue+=pieData.getValue();
            int j=i %mColors.length;
            pieData.setColor(mColors[j]);
        }
        float sumAngle=0;
        for (int i = 0; i < pieDataArrayList.size(); i++) {
            PieData pieData=pieDataArrayList.get(i);
            float percentage=pieData.getValue()/sumValue;
            float angle = percentage * 360;
            pieData.setPercentage(percentage);                  // 记录百分比
            pieData.setAngle(angle);                            // 记录角度大小
            sumAngle += angle;

            Log.i("angle", "" + pieData.getAngle());
        }
    }
}
