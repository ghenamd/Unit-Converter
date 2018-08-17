package com.zappcompany.unitconverter.volume.di;

import com.digidemic.unitof.UnitOf;
import com.zappcompany.unitconverter.volume.VolumeCalculator;

import java.text.DecimalFormat;
import java.util.HashMap;

import dagger.Module;
import dagger.Provides;

import static com.zappcompany.unitconverter.volume.constants.VolumeConstants.LITER;
import static com.zappcompany.unitconverter.volume.constants.VolumeConstants.MILLILITER;

@Module
public class VolumeCalculatorModule {

    @UnitConverterApplicationScope
    @Provides
    public VolumeCalculator volumeCalculator(UnitOf.Anything unit, DecimalFormat df) {
        return new VolumeCalculator(unit, df);
    }

    @UnitConverterApplicationScope
    @Provides
    public DecimalFormat decimalFormat() {
        return new DecimalFormat("#.####");
    }

    @UnitConverterApplicationScope
    @Provides
    public UnitOf.Anything volumeUnit() {
        return new UnitOf.Anything(LITER, new HashMap<Object, Double>() {{
            put(MILLILITER, 1000.0);
        }});
    }
}
