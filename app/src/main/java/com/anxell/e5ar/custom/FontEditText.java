package com.anxell.e5ar.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

import com.anxell.e5ar.Config;


/**
 * Created by nsdi-monkey on 2017/2/14.
 */

public class FontEditText extends EditText {

    public FontEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 設定字型
        setTypeface(Typeface.createFromAsset(context.getAssets(), Config.TYPEFACE));
    }
}
