package com.screenmedia.fuelcost.constants;

public interface Constants {
    String CSV_FILE_PATH = "classpath:fuel-cost.csv";

    String ULSP = "ulsp";
    String ULSD = "ulsd";
    Double ZERO = 0.0;
    int HUNDRED = 100;
    Double GALLON_TO_LITRE = 3.78541;
    int THREE =3;

    int DATE = 0;
    int ULSP_PUMP_PRICE = 1;
    int ULSD_PUMP_PRICE = 2;
    int ULSP_DUTY_PRICE = 3;
    int ULSD_DUTY_PRICE = 4;
    int ULSP_VAT_RATE = 5;
    int ULSD_VAT_RATE = 6;
}
