package com.zappcompany.unitconverter.volume.di;

import com.zappcompany.unitconverter.volume.VolumeCalculator;
import com.zappcompany.unitconverter.volume.textwatcher.CustomVolumeTextWatcher;

import dagger.Module;
import dagger.Provides;

@Module(includes = VolumeCalculatorModule.class)
public class CustomVolumeTextWatcherModule {


    @Provides
    public CustomVolumeTextWatcher getCustomTextWatcher( VolumeCalculator calculator){
        return new CustomVolumeTextWatcher(calculator);
    }
}
