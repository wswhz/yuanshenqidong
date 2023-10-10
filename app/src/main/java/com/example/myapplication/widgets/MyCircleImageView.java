package com.example.myapplication.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

import org.jetbrains.annotations.NotNull;

public class MyCircleImageView extends androidx.appcompat.widget.AppCompatImageView {
    private Context mContext;
    private Bitmap mask;
    private Paint paint;
    private int mBorderWidth = 10;
    private int BorderColor = Color.parseColor("#f2f2f2");

    public MyCircleImageView(Context context,AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        TypedArray a=context.obtainStyledAttributes(attrs, R.styleable.MyCircleImageAttr);
        BorderColor = a.getColor (R.styleable.MyCircleImageAttr_border_color,BorderColor);
        mBorderWidth=a.getDimensionPixelOffset(R.styleable.MyCircleImageAttr_border_width,mBorderWidth);
   a.recycle();
    }

    private Bitmap createOvalBitmap(int width, int height) {
        Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
        Bitmap localBitmap = Bitmap.createBitmap(width, height, localConfig);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        int padding = (mBorderWidth - 2) > 0 ? mBorderWidth - 2 : 1;
        RectF localRectF = new RectF(padding, padding, width - padding, height - padding);
        localCanvas.drawOval(localRectF, localPaint);
        return localBitmap;
    }

    private void drawBorder(Canvas canvas, int width, int height) {
        if (mBorderWidth == 0) {
            return;
        }
        final Paint mBorderPaint = new Paint();
        mBorderPaint.setStyle(Paint.Style.STROKE);
        mBorderPaint.setAntiAlias(true);
        mBorderPaint.setColor(BorderColor);
        mBorderPaint.setStrokeWidth(mBorderWidth);
        canvas.drawCircle(width >> 1, height >> 1, (width - mBorderWidth) >> 1, mBorderPaint);
        canvas = null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) { return; }
        int width = getWidth();
        int height = getHeight();
        int layer = canvas.saveLayer(0.0f,0.0f,width, height, null,Canvas.ALL_SAVE_FLAG);
        drawable.setBounds(0,0,width, height);
        drawable.draw(canvas);
        if (mask == null|| mask.isRecycled()) {
            mask = createOvalBitmap(width, height);
        }
        canvas.drawBitmap(mask,0,0,paint);
        canvas.restoreToCount(layer);
        drawBorder(canvas,width, height);
    }
}

