package com.zappcompany.unitconverter.volume.volumetextwatcher;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.zappcompany.unitconverter.volume.volumecalculator.VolumeCalculator;

import java.util.HashMap;

import static com.zappcompany.unitconverter.volume.volumeconstants.VolumeConstants.LITER;
import static com.zappcompany.unitconverter.volume.volumeconstants.VolumeConstants.MILLILITER;

public class CustomVolumeTextWatcher {

    private VolumeCalculator mVolumeCalculator;

    public CustomVolumeTextWatcher(VolumeCalculator volumeCalculator ) {

        mVolumeCalculator = volumeCalculator;
    }

    public void setValuesPerEditText(final HashMap<String, EditText> mHashMap) {
        for (final EditText editText : mHashMap.values()) {

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
                        if (editText == mHashMap.get(MILLILITER)) {
                            //Apply custom behavior just for this editText
                            editText.removeTextChangedListener(this);
                            mHashMap.get(LITER).setText(mVolumeCalculator.calculateLiter(value));
                            editText.addTextChangedListener(this);

                        } else if (editText == mHashMap.get(LITER)) {
                            editText.removeTextChangedListener(this);
                            mHashMap.get(MILLILITER).setText(mVolumeCalculator.calculateMilliliter(value));
                            editText.addTextChangedListener(this);
                        }
                    }

                }
            });
        }


    }
}