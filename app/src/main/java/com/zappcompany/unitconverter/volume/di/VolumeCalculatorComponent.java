package com.zappcompany.unitconverter.volume.di;

import com.zappcompany.unitconverter.volume.VolumeCalculator;

import dagger.Component;
@UnitConverterApplicationScope
@Component(modules = {VolumeModule.class})
public interface VolumeCalculatorComponent {

    VolumeCalculator getVolumeCalculator();
}
