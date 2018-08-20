package com.zappcompany.unitconverter.volume.volumedi;

import com.zappcompany.unitconverter.volume.volumecalculator.VolumeCalculator;
import com.zappcompany.unitconverter.volume.volumetextwatcher.CustomVolumeTextWatcher;

import dagger.Module;
import dagger.Provides;

@Module(includes = VolumeCalculatorModule.class)
public class CustomVolumeTextWatcherModule {


    @Provides
    public CustomVolumeTextWatcher getCustomTextWatcher( VolumeCalculator calculator){
        return new CustomVolumeTextWatcher(calculator);
    }

}
