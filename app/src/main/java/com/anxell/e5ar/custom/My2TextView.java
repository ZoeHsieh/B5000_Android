package com.anxell.e5ar.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.anxell.e5ar.R;

/**
 * Created by kay on 2017/6/8.
 */

public class My2TextView extends FrameLayout {
    private FontTextView mTitleTV;
    private FontTextView mValueTV;
    private ImageView mIndicatorView;

    public My2TextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.my_2_textview, this);

        mTitleTV = (FontTextView) findViewById(R.id.title);
        mValueTV = (FontTextView) findViewById(R.id.value);
        mIndicatorView = (ImageView) findViewById(R.id.indicator);
        mValueTV.setTextColor(getResources().getColor(R.color.gray2));
//        mValueTV.setTextColor(getResources().getColor(R.color.green));
        showMyAttrs(context, attrs);
    }

    private void showMyAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyFieldAttr);
        String title = typedArray.getString(R.styleable.MyFieldAttr_myTitle);
        mTitleTV.setText(title);

        String value = typedArray.getString(R.styleable.MyFieldAttr_value);
        if (!TextUtils.isEmpty(value)) {
            mValueTV.setText(value);
        }
        else
        {
            mValueTV.setVisibility(View.GONE);
        }

        boolean showIndicator = typedArray.getBoolean(R.styleable.MyFieldAttr_showIndicator, true);
        if (!showIndicator) {
            findViewById(R.id.indicator).setVisibility(View.INVISIBLE);
        }

        typedArray.recycle();
    }
    public void setIndicatorViewVisibility(boolean enable){
        if(enable)
            mIndicatorView.setVisibility(View.VISIBLE);
        else
            mIndicatorView.setVisibility(View.INVISIBLE);
    }
    public String getValue() {
        return mValueTV.getText().toString();
    }

    public void setValue(String value) {
        mValueTV.setText(value);
    }
}