package com.zappcompany.unitconverter.volume;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.zappcompany.unitconverter.R;
import com.zappcompany.unitconverter.volume.di.DaggerVolumeComponent;
import com.zappcompany.unitconverter.volume.di.VolumeComponent;
import com.zappcompany.unitconverter.volume.textwatcher.CustomVolumeTextWatcher;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.zappcompany.unitconverter.volume.constants.VolumeConstants.LITER;
import static com.zappcompany.unitconverter.volume.constants.VolumeConstants.MILLILITER;

public class VolumeActivity extends AppCompatActivity  {

    @BindView(R.id.edit_text_milliliter)
    EditText milliliter;
    @BindView(R.id.edit_text_liter)
    EditText liter;

    CustomVolumeTextWatcher mTextWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
        ButterKnife.bind(this);
        setTitle(getString(R.string.volume));

        //Use HasMap with EditText to pass it in CustomVolumeTextWatcher
        HashMap<String,EditText> hashMap = new HashMap<>();
        hashMap.put(MILLILITER,milliliter);
        hashMap.put(LITER,liter);

        VolumeComponent component = DaggerVolumeComponent.builder().build();
        mTextWatcher = component.getCustomVolumeTextWatcher();
        mTextWatcher.setValuesPerEditText(hashMap);

    }


}
