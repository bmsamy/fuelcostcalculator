package com.screenmedia.fuelcost.services;

import static com.screenmedia.fuelcost.constants.Constants.*;

import com.screenmedia.fuelcost.model.Cost;
import com.screenmedia.fuelcost.persistence.Fuel;
import com.screenmedia.fuelcost.persistence.FuelRepository;
import com.screenmedia.fuelcost.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class CostServiceImpl implements CostService {

    //3.78541
    @Autowired
    private FuelRepository fuelRepository;


    @Override
    public Cost calculateJourneyCost(LocalDate travelDate, String type, Double mpg, Double mileage) {

        Double pumpPrice = ZERO;
        Double todayPumpPrice = ZERO;
        Double dutyPrice = ZERO;
        Double litresRequired = mileage/mpg * GALLON_TO_LITRE;

        Fuel fuelPriceForTravelDate = fuelRepository.findTop1ByStartDateBeforeOrderByStartDateDesc(travelDate);
        Fuel fuelPriceForToday = fuelRepository.findTop1ByStartDateBeforeOrderByStartDateDesc(LocalDate.now());

        if (ULSP.equalsIgnoreCase(type)){
            pumpPrice = fuelPriceForTravelDate.getPetrolPumpPrice();
            dutyPrice = fuelPriceForTravelDate.getPetrolDutyPrice();
            todayPumpPrice = fuelPriceForToday.getPetrolPumpPrice();

        }else if(ULSD.equalsIgnoreCase(type)){
            pumpPrice = fuelPriceForTravelDate.getDieselPumpPrice();
            dutyPrice = fuelPriceForTravelDate.getDieselDutyPrice();
            todayPumpPrice = fuelPriceForToday.getDieselPumpPrice();
        }


        Double journeyCost = litresRequired * pumpPrice / HUNDRED;
        Double dutyPaid = litresRequired * dutyPrice / HUNDRED;
        Double todayCost = litresRequired * todayPumpPrice / HUNDRED;

        Cost cost = new Cost(Util.formatCost(journeyCost), Util.formatCost(dutyPaid), todayCost-journeyCost);

        return cost;
    }
}
