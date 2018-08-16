package com.zappcompany.unitconverter.volume;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.zappcompany.unitconverter.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VolumeActivity extends AppCompatActivity {

    @BindView(R.id.edit_text_milliliter)
    EditText milliliter;
    @BindView(R.id.edit_text_liter)
    EditText liter;
    private static final String TAG = "VolumeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
        ButterKnife.bind(this);
        setTitle(getString(R.string.volume));
        milliliter.addTextChangedListener(customTextWatcher);
        liter.addTextChangedListener(customTextWatcher);

    }

    TextWatcher customTextWatcher = new TextWatcher()  {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (editable!= null && editable.length() != 0) {

                double value  = Double.parseDouble(editable.toString());

                if (liter.getText().hashCode() == editable.hashCode()) {
                    liter.removeTextChangedListener(customTextWatcher);
                    milliliter.setText(VolumeCalculator.calculateMilliliter(value));
                    liter.addTextChangedListener(customTextWatcher);

                } else if (milliliter.getText().hashCode() == editable.hashCode()) {
                    milliliter.removeTextChangedListener(customTextWatcher);
                    liter.setText(VolumeCalculator.calculateLiter(value));
                    milliliter.addTextChangedListener(customTextWatcher);

                }
            }
        }
    };


}
