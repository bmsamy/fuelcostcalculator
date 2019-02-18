package com.screenmedia.fuelcost.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class Util {

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static DateTimeFormatter inputDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static DecimalFormat decimalFormat = new DecimalFormat("####.##");

    public static Double formatCost(Double cost){

        Double formattedCost = null;
        if(null != cost) {
            String costStr = decimalFormat.format(cost.doubleValue());

            formattedCost = Double.valueOf(costStr);
        }
        return formattedCost;
    }
}
