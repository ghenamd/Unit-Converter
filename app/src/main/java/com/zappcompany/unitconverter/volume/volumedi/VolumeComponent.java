package com.zappcompany.unitconverter.volume.volumedi;

import android.content.Context;

import com.zappcompany.unitconverter.volume.VolumeActivity;

import dagger.Component;

@UnitConverterApplicationScope
@Component(modules = {CustomTextListenerModule.class,ContextModule.class})
public interface VolumeComponent {
    Context context();
    void injectVolumeActivity(VolumeActivity volumeActivity);
}
