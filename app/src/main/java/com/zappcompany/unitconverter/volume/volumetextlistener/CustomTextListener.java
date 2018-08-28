package com.zappcompany.unitconverter.volume.volumetextlistener;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.zappcompany.unitconverter.volume.inputdialog.InputDialog;
import com.zappcompany.unitconverter.volume.volumecalculator.VolumeCalculator;

import java.util.HashMap;

import static com.zappcompany.unitconverter.volume.volumeconstants.VolumeConstants.LITER;
import static com.zappcompany.unitconverter.volume.volumeconstants.VolumeConstants.MILLILITER;

public class CustomTextListener {

    private VolumeCalculator mVolumeCalculator;
    private InputDialog mInputDialog;

    public CustomTextListener(VolumeCalculator volumeCalculator, InputDialog inputDialog) {

        mVolumeCalculator = volumeCalculator;
        mInputDialog = inputDialog;
    }

    public void setValuesPerText(final HashMap<String, TextView> mHashMap) {
        for (final TextView textView : mHashMap.values()) {
            textView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    mInputDialog.openInputDialog(textView);
                    if (textView == mHashMap.get(MILLILITER)) {

                        double value = Double.parseDouble(textView.getText().toString());
                        mHashMap.get(LITER).setText(mVolumeCalculator.calculateLiter(value));


                    } else if (textView == mHashMap.get(LITER)) {

                        double value = Double.parseDouble(textView.getText().toString());
                        mHashMap.get(MILLILITER).setText(mVolumeCalculator.calculateMilliliter(value));

                    }
                }
            });

        }


    }
}