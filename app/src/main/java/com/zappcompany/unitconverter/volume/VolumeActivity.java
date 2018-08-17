package com.zappcompany.unitconverter.volume;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.zappcompany.unitconverter.R;
import com.zappcompany.unitconverter.textwatcher.CustomTextWatcher;
import com.zappcompany.unitconverter.volume.di.DaggerVolumeCalculatorComponent;
import com.zappcompany.unitconverter.volume.di.VolumeCalculatorComponent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VolumeActivity extends AppCompatActivity  {

    @BindView(R.id.edit_text_milliliter)
    EditText milliliter;
    @BindView(R.id.edit_text_liter)
    EditText liter;
    VolumeCalculator volumeCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
        ButterKnife.bind(this);
        setTitle(getString(R.string.volume));
        List<EditText> editTextList = new ArrayList<>();
        editTextList.add(milliliter);
        editTextList.add(liter);
        VolumeCalculatorComponent volumeCalculatorComponent = DaggerVolumeCalculatorComponent.builder().build();
        volumeCalculator = volumeCalculatorComponent.getVolumeCalculator();
//        milliliter.addTextChangedListener(this);
//        liter.addTextChangedListener(this);
        CustomTextWatcher customTextWatcher = new CustomTextWatcher(editTextList,volumeCalculator);
        customTextWatcher.setValuesPerEditText();


    }

//    @Override
//    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//    }
//
//    @Override
//    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//    }
//
//    @Override
//    public void afterTextChanged(Editable editable) {
//        if (editable != null && editable.length() != 0) {
//
//            double value = Double.parseDouble(editable.toString());
//
//            if (liter.getText().hashCode() == editable.hashCode()) {
//                liter.removeTextChangedListener(this);
//                milliliter.setText(volumeCalculator.calculateMilliliter(value));
//                liter.addTextChangedListener(this);
//
//            } else if (milliliter.getText().hashCode() == editable.hashCode()) {
//                milliliter.removeTextChangedListener(this);
//                liter.setText(volumeCalculator.calculateLiter(value));
//                milliliter.addTextChangedListener(this);
//
//            }
//        }
//    }

}
