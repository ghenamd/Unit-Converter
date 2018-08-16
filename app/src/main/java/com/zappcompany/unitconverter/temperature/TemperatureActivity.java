package com.zappcompany.unitconverter.temperature;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zappcompany.unitconverter.R;

public class TemperatureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        setTitle(getString(R.string.temperature));
    }
}
