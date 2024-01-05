package com.adolfoponce.spinning.utils.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.widget.AppCompatSpinner;

public class CustomSpinner extends AppCompatSpinner {
    OnItemSelectedListener listener;
    private AdapterView<?> lastParent;
    private View lastView;
    private long lastId;
    private boolean callService = false;
    private OnSpinnerEventsListener mListener;
    private boolean mOpenInitiated = false;

    public CustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        initlistner();
    }

    @Override
    public void setSelection(int position) {
        if (position == getSelectedItemPosition() && listener != null) {
            listener.onItemSelected(lastParent, lastView, position, lastId);
        } else {
            super.setSelection(position);
        }

    }

    @Override
    public boolean performClick() {
        mOpenInitiated = true;
        if (mListener != null) {
            mListener.onSpinnerOpened(this);
        }
        return super.performClick();
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        if (mOpenInitiated && hasWindowFocus) {
            mOpenInitiated = false;
            if (mListener != null) {
                mListener.onSpinnerClosed(this);
            }
        }
        super.onWindowFocusChanged(hasWindowFocus);
    }

    private void initlistner() {
        super.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                lastParent = parent;
                lastView = view;
                lastId = id;
                if (listener != null && callService) {
                    listener.onItemSelected(parent, view, position, id);
                }
                callService = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                if (listener != null) {
                    listener.onNothingSelected(parent);
                }
            }
        });

    }

    public void setOnItemSelectedEvenIfUnchangedListener(
            OnItemSelectedListener listener) {
        this.listener = listener;
    }

    public void setEventsListener(OnSpinnerEventsListener mListener) {
        this.mListener = mListener;
    }

    public interface OnSpinnerEventsListener {
        void onSpinnerOpened(AppCompatSpinner spinner);
        void onSpinnerClosed(AppCompatSpinner spinner);
    }
}