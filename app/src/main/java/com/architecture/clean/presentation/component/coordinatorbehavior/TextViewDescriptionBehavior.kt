package com.architecture.clean.presentation.component.coordinatorbehavior

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.widget.NestedScrollView
import com.architecture.clean.R

// todo can be added a presenter
class TextViewDescriptionBehavior(context: Context?, attrs: AttributeSet?) : CoordinatorLayout.Behavior<TextView>(context, attrs) {
    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: TextView, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type)

        val parentHeight = coordinatorLayout.height
        val childHeight = child.height
        val scrollY = (target as NestedScrollView).scrollY

        child.y = (parentHeight - childHeight + scrollY).toFloat()
    }

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: TextView, directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
        if (target.id == R.id.scroll_text_example && ViewCompat.SCROLL_AXIS_VERTICAL == axes) {
            return true
        }
        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type)
    }
}