package com.zappcompany.unitconverter.customview;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

public class CustomEditText extends AppCompatEditText {

    public CustomEditText(Context context) {
        super(context);


    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    //Moves cursor at the end of EditText
    @Override
    protected void onSelectionChanged(int selStart, int selEnd) {
        this.setSelection(this.getText().length());
    }


}
