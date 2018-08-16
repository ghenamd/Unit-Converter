package com.zappcompany.unitconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.zappcompany.unitconverter.temperature.TemperatureActivity;
import com.zappcompany.unitconverter.volume.VolumeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.volume)
    ImageButton mVolume;
    @BindView(R.id.temp)
    ImageButton mTemp;
    @BindView(R.id.area)
    ImageButton mArea;
    @BindView(R.id.speed)
    ImageButton mSpeed;
    @BindView(R.id.mass)
    ImageButton mMass;
    @BindView(R.id.time)
    ImageButton mTime;
    @BindView(R.id.fuel)
    ImageButton mFuel;
    @BindView(R.id.bar)
    ImageButton mBar;
    @BindView(R.id.power)
    ImageButton mPower;
    @BindView(R.id.energy)
    ImageButton mEnergy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        openVolumeActivity();
        openTemperatureActivity();

    }

    private void openVolumeActivity(){
        mVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volumeActivity = new Intent(MainActivity.this, VolumeActivity.class);
                startActivity(volumeActivity);
            }
        });
    }
    private void openTemperatureActivity(){
        mTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent temperatureActivity = new Intent(MainActivity.this, TemperatureActivity.class);
                startActivity(temperatureActivity);
            }
        });
    }

}
