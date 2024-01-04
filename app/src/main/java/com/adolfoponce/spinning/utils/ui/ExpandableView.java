package com.adolfoponce.spinning.utils.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.adolfoponce.spinning.R;


public class ExpandableView extends ConstraintLayout {

    public static final String KEY_SUPER_STATE = "KEY_SUPER_STATE";
    public static final String KEY_EXPANSION = "KEY_EXPANSION";

    private static final int DEFAULT_DURATION = 375;

    private Interpolator interpolator;
    private ValueAnimator animator;

    private float expansion;
    private int duration;
    private State state;


    public ExpandableView(@NonNull Context context) {
        this(context, null, 0);
    }

    public ExpandableView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExpandableView(@NonNull Context context, @Nullable AttributeSet attrs,
                          int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs, context);
    }

    private void initAttrs(AttributeSet attrs, Context context) {
        if (attrs == null) return;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ExpandableView);
        duration = typedArray.getInt(R.styleable.ExpandableView_anim_duration, DEFAULT_DURATION);
        expansion = typedArray.getBoolean(R.styleable.ExpandableView_expanded, false) ? 1 : 0;

        int interpolatorResId = typedArray.getResourceId(R.styleable.ExpandableView_interpolator, -1);

        interpolator = interpolatorResId != -1 ? AnimationUtils.loadInterpolator(context,
                interpolatorResId) : new AccelerateDecelerateInterpolator();
        state = expansion == 0 ? State.COLLAPSED : State.EXPANDED;
        typedArray.recycle();
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();

        expansion = isExpanded() ? 1 : 0;

        bundle.putFloat(KEY_EXPANSION, expansion);
        bundle.putParcelable(KEY_SUPER_STATE, superState);

        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        expansion = bundle.getFloat(KEY_EXPANSION);
        state = expansion == 1 ? State.EXPANDED : State.COLLAPSED;
        Parcelable superState = bundle.getParcelable(KEY_SUPER_STATE);

        super.onRestoreInstanceState(superState);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        setVisibility(expansion == 0 && height == 0 ? GONE : VISIBLE);
        int expansionDelta = height - Math.round(height * expansion);
        setMeasuredDimension(width, height - expansionDelta);
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        if (animator != null) {
            animator.cancel();
        }
        super.onConfigurationChanged(newConfig);
    }

    public State getState() {
        return state;
    }

    public boolean isExpanded() {
        return state == State.EXPANDING || state == State.EXPANDED;
    }

    public void toggle() {
        if (isExpanded()) {
            collapse();
        } else {
            expand();
        }
    }

    public void expand() {
        setExpanded(true);
    }

    public void collapse() {
        setExpanded(false);
    }

    private void setExpanded(boolean expand) {
        if (expand == isExpanded()) {
            return;
        }

        int targetExpansion = expand ? 1 : 0;
        animateSize(targetExpansion);
    }

    public void setExpansion(float expansion) {
        if (this.expansion == expansion) {
            return;
        }

        float delta = expansion - this.expansion;
        if (expansion == 0) {
            state = State.COLLAPSED;
        } else if (expansion == 1) {
            state = State.EXPANDED;
        } else if (delta < 0) {
            state = State.COLLAPSING;
        } else if (delta > 0) {
            state = State.EXPANDING;
        }
        setVisibility(state == State.COLLAPSED ? GONE : VISIBLE);
        this.expansion = expansion;
        requestLayout();
    }

    private void animateSize(int targetExpansion) {
        if (animator != null) {
            animator.cancel();
            animator = null;
        }

        animator = ValueAnimator.ofFloat(expansion, targetExpansion);
        animator.setInterpolator(interpolator);
        animator.setDuration(duration);
        animator.addUpdateListener(animation -> setExpansion((Float) animation.getAnimatedValue()));
        animator.start();
    }

    public enum State {
        COLLAPSED, COLLAPSING, EXPANDING, EXPANDED
    }
}