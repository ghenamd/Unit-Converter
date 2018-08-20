package com.zappcompany.unitconverter.volume;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.zappcompany.unitconverter.R;
import com.zappcompany.unitconverter.volume.volumedi.ContextModule;
import com.zappcompany.unitconverter.volume.volumedi.DaggerVolumeComponent;
import com.zappcompany.unitconverter.volume.volumedi.VolumeComponent;
import com.zappcompany.unitconverter.volume.volumetextwatcher.CustomVolumeTextWatcher;

import java.util.HashMap;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.zappcompany.unitconverter.volume.volumeconstants.VolumeConstants.LITER;
import static com.zappcompany.unitconverter.volume.volumeconstants.VolumeConstants.MILLILITER;

public class VolumeActivity extends AppCompatActivity {

    @BindView(R.id.edit_text_milliliter)
    EditText milliliter;
    @BindView(R.id.edit_text_liter)
    EditText liter;
    @Inject
    CustomVolumeTextWatcher mTextWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
        ButterKnife.bind(this);
        setTitle(getString(R.string.volume));

        //Use HasMap with EditText to pass it in CustomVolumeTextWatcher
        HashMap<String, EditText> hashMap = new HashMap<>();
        hashMap.put(MILLILITER, milliliter);
        hashMap.put(LITER, liter);

        VolumeComponent volumeComponent = DaggerVolumeComponent.builder()
                .contextModule(new ContextModule(this)).build();
        volumeComponent.injectVolumeActivity(this);
        mTextWatcher.setValuesPerEditText(hashMap);

    }

}
