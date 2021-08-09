package com.bgyhnddr.nestedscrolldemo

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.core.widget.NestedScrollView

class ParentScroll @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : NestedScrollView(context, attrs, defStyleAttr) {
    private lateinit var topView: View;
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val height = MeasureSpec.getSize(heightMeasureSpec);
        val view = getChildAt(0);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        topView = findViewById<View>(R.id.topBar);
        view.measure(
            widthMeasureSpec,
            MeasureSpec.makeMeasureSpec(
                height + topView.layoutParams.height,
                MeasureSpec.EXACTLY
            )
        )
    }

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        Log.v("parent onNestedPreScroll", scrollY.toString())
        Log.v("parent onNestedPreScroll topView.height", topView.height.toString())
        Log.v("parent onNestedPreScroll dy", dy.toString())
        if (dy > 0) {
            if (scrollY < topView.height) {
                val leftY = topView.height - scrollY
                val consumedY = if (dy <= leftY) dy else leftY

                scrollBy(0, consumedY)
                consumed[1] = consumedY
            }
        }
    }
}