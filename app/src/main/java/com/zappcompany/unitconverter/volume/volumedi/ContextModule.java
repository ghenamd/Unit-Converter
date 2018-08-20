package com.zappcompany.unitconverter.volume.volumedi;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
   private final  Context mContext;

    public ContextModule(Activity context) {
        mContext = context;
    }


    @UnitConverterApplicationScope
    @Provides
    public Context getContext() {
        return mContext;
    }
}
