package com.zappcompany.unitconverter.volume.di;

import com.zappcompany.unitconverter.volume.textwatcher.CustomVolumeTextWatcher;

import dagger.Component;

@UnitConverterApplicationScope
@Component(modules = {CustomVolumeTextWatcherModule.class})
public interface VolumeComponent {

    CustomVolumeTextWatcher getCustomVolumeTextWatcher();
}
