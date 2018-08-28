package com.zappcompany.unitconverter.volume.volumedi;

import android.content.Context;

import com.zappcompany.unitconverter.volume.inputdialog.InputDialog;

import dagger.Module;
import dagger.Provides;

@Module (includes = ContextModule.class)
public class InputDialogModule {


    @Provides
    public InputDialog inputDialog(Context context){
        return new InputDialog(context);
    }


}
