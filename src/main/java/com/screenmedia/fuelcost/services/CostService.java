package com.screenmedia.fuelcost.services;


import com.screenmedia.fuelcost.model.Cost;

import java.time.LocalDate;

public interface CostService {

    Cost calculateJourneyCost(LocalDate travelDate, String type, Double mpg, Double  mileage);
}
