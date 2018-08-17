package com.zappcompany.unitconverter.textwatcher;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.zappcompany.unitconverter.volume.VolumeCalculator;

import java.util.List;

public class CustomTextWatcher {

    private List<EditText> mTextList;

    private VolumeCalculator mVolumeCalculator;

    public CustomTextWatcher(List<EditText> textList, VolumeCalculator volumeCalculator) {
        mTextList = textList;
        mVolumeCalculator = volumeCalculator;
    }

    public void setValuesPerEditText() {
        for (final EditText editText : mTextList) { //need to be final for custom behaviors
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    //Apply general behavior for all editTexts
                    if (editable != null && editable.length() != 0) {
                        double value = Double.parseDouble(editable.toString());
                        if (editText == mTextList.get(0)) {
                            //Apply custom behavior just for this editText
                            editText.removeTextChangedListener(this);
                            mTextList.get(1).setText(mVolumeCalculator.calculateLiter(value));
                            editText.addTextChangedListener(this);

                        }else if (editText == mTextList.get(1)){
                            editText.removeTextChangedListener(this);
                            mTextList.get(0).setText(mVolumeCalculator.calculateMilliliter(value));
                            editText.addTextChangedListener(this);
                        }
                    }

                }
            });
        }


    }
}