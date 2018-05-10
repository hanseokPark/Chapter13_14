package kr.or.dgit.it.chapter13_14;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class DonutView extends View{

    Context context;
    int value;
    int size;
    int strokeSize;
    int textSize;

    int width;
    int height;


    public DonutView(Context context) {
        super(context);
        this.context = context;
        /*init();*/
    }

    public DonutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        /*init();*/
    }

    public DonutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        /*init();*/
    }

    private void init(AttributeSet attrs) {
        size = getResources().getDimensionPixelSize(R.dimen.donut_size);


       /* //이미지 로딩
        plusBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.plus);
        minusBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.minus);

        //터치포인트의 포함여부를 알기위한 면적
        plusRectDst = new Rect(10,10,210,210);
        minusRectDst = new Rect(400,10,600,210);

        if(attrs != null){
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView);
            textColor = typedArray.getColor(R.styleable.MyView_customTextColor, Color.RED);
        }
        listeners = new ArrayList<>();*/
    }

}
