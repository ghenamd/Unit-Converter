package com.zappcompany.unitconverter.volume;


import com.digidemic.unitof.UnitOf;

import java.text.DecimalFormat;
import java.util.HashMap;

public class VolumeCalculator {

    private static final String LITER = "LITER";
    private static final String MILLILITER = "MILLILITER";
    private static DecimalFormat df = new DecimalFormat("#.####");
    private static UnitOf.Anything volume = new UnitOf.Anything(LITER, new HashMap<Object, Double>() {{
        put(MILLILITER, 1000.0);
    }});


    public static String calculateLiter(double d) {
        double liter = volume.convertNow(d, MILLILITER, LITER);
        return String.valueOf(df.format(liter));

    }
    public static String calculateMilliliter(double d){
        double milliliter = volume.convertNow(d,LITER,MILLILITER);
        return String.valueOf(df.format(milliliter));
    }

}
