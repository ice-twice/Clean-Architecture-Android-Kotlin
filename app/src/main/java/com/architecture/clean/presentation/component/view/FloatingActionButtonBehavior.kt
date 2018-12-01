package com.architecture.clean.presentation.component.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.widget.NestedScrollView
import com.architecture.clean.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

// todo can be added a presenter
class FloatingActionButtonBehavior(context: Context?, attrs: AttributeSet?) : CoordinatorLayout.Behavior<FloatingActionButton>(context, attrs) {
    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type)

        val parentHeight = coordinatorLayout.height
        val scrollY = (target as NestedScrollView).scrollY
        val scrollChildHeight = if (target.childCount > 0) target.getChildAt(0).height else 0
        val scrollYPosition = scrollY + parentHeight * (scrollY.toFloat() / (scrollChildHeight - parentHeight))
        val scrollPassedWay = scrollYPosition / scrollChildHeight
        val buttonLayoutParams = child.layoutParams as ViewGroup.MarginLayoutParams
        val rightDistanceForButton = parentHeight - buttonLayoutParams.topMargin - buttonLayoutParams.bottomMargin - child.height
        val buttonTop = rightDistanceForButton - rightDistanceForButton * scrollPassedWay + buttonLayoutParams.topMargin
        child.y = buttonTop
    }

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton, directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
        if (target.id == R.id.scroll_text_example && ViewCompat.SCROLL_AXIS_VERTICAL == axes) {
            return true
        }
        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type)
    }
}