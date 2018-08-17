package com.zappcompany.unitconverter.volume.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    Context mContext;

    public ContextModule(Context context) {
        mContext = context;
    }
    @UnitConverterApplicationScope
    @Provides
    public Context getContext() {
        return mContext.getApplicationContext();
    }
}
