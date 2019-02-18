package com.screenmedia.fuelcost.controllers;

import com.screenmedia.fuelcost.exception.InvalidRequestException;
import com.screenmedia.fuelcost.model.Cost;
import com.screenmedia.fuelcost.services.CostService;
import com.screenmedia.fuelcost.utils.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("fuel")
public class CostController {

    private static final Logger log = LoggerFactory
            .getLogger(CostController.class);
    @Autowired
    private CostService costService;

    @GetMapping("/cost/{travelDate}/{fuelType}/{mpg}/{mileage}")
    public Cost retrieveData(@PathVariable String travelDate, @PathVariable String fuelType, @PathVariable Double mpg, @PathVariable Double mileage) {

        Cost cost = null;
        try {
            LocalDate tdate = LocalDate.parse(travelDate, Util.inputDateFormat);
            cost = costService.calculateJourneyCost(tdate, fuelType, mpg, mileage);
        } catch (DateTimeParseException e) {
            log.error("Failed to parse travel date : " + travelDate);
            throw new InvalidRequestException("Failed to parse travel date : " + travelDate);
        }
        if (null == cost) {
            throw new InvalidRequestException("Unable to calculate cost. Please check input parameters");
        }
        return cost;
    }


}
