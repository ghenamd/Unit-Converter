package com.zappcompany.unitconverter.volume;


import com.digidemic.unitof.UnitOf;

import java.text.DecimalFormat;

import static com.zappcompany.unitconverter.volume.constants.VolumeConstants.LITER;
import static com.zappcompany.unitconverter.volume.constants.VolumeConstants.MILLILITER;

public class VolumeCalculator {


    private UnitOf.Anything volume;
    private DecimalFormat df;

    public VolumeCalculator(UnitOf.Anything volume, DecimalFormat df) {
        this.volume = volume;
        this.df = df;
    }

    public  String calculateLiter(double d) {
        double liter = volume.convertNow(d, MILLILITER, LITER);
        return String.valueOf(df.format(liter));

    }
    public  String calculateMilliliter(double d){
        double milliliter = volume.convertNow(d,LITER,MILLILITER);
        return String.valueOf(df.format(milliliter));
    }

}
