package com.example.ruanyulin.tab_23;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by ruanyulin on 17-8-15.
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ATTRS = new int[]{
            android.R.attr.listDivider
    };

    public static final int horizontal = LinearLayoutManager.HORIZONTAL;
    public static final int vertical = LinearLayoutManager.VERTICAL;

    private Drawable drawable;
    private int morientation;

    public DividerItemDecoration(Context context,int orientation) {
        final TypedArray typedArray = context.obtainStyledAttributes(ATTRS);
        drawable = typedArray.getDrawable(0);
        typedArray.recycle();
        morientation = orientation;
    }


    @Override
    public void onDraw(Canvas canvas,RecyclerView parent) {
        horizontalDrawer(canvas, parent);
    }

    private void horizontalDrawer(Canvas canvas,RecyclerView parent){
        int left = parent.getPaddingLeft();
        int right = parent.getWidth()-parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0;i < childCount; i++){
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)child.getLayoutParams();
            int top = child.getBottom()+layoutParams.bottomMargin;
            int bottom = top+drawable.getIntrinsicHeight();
            drawable.setBounds(left,top,right,bottom);
            drawable.draw(canvas);
        }
    }
}
