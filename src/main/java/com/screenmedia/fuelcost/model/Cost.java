package com.screenmedia.fuelcost.model;

public class Cost {

    Double totalJourneyCost;
    Double dutyPaid;
    Double difference;

    public Cost(Double totalJourneyCost, Double dutyPaid, Double difference) {
        this.totalJourneyCost = totalJourneyCost;
        this.dutyPaid = dutyPaid;
        this.difference = difference;
    }

    public Double getTotalJourneyCost() {
        return totalJourneyCost;
    }

    public Double getDutyPaid() {
        return dutyPaid;
    }

    public Double getDifference() {
        return difference;
    }
}
