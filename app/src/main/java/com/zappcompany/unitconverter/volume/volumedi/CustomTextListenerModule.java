package com.zappcompany.unitconverter.volume.volumedi;

import com.zappcompany.unitconverter.volume.inputdialog.InputDialog;
import com.zappcompany.unitconverter.volume.volumecalculator.VolumeCalculator;
import com.zappcompany.unitconverter.volume.volumetextlistener.CustomTextListener;

import dagger.Module;
import dagger.Provides;

@Module(includes = {VolumeCalculatorModule.class,InputDialogModule.class})
public class CustomTextListenerModule {

    @Provides
    public CustomTextListener getTextListener(VolumeCalculator volumeCalculator, InputDialog inputDialog){
        return new CustomTextListener(volumeCalculator,inputDialog);
    }

}
