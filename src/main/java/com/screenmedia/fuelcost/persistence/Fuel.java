package com.screenmedia.fuelcost.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Fuel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate startDate;
    private Double petrolPumpPrice;
    private Double dieselPumpPrice;
    private Double petrolDutyPrice;
    private Double dieselDutyPrice;
    private Double petrolVat;
    private Double dieselVat;

    protected Fuel(){}

    public Fuel(LocalDate startDate, Double petrolPumpPrice, Double dieselPumpPrice, Double petrolDutyPrice, Double dieselDutyPrice, Double petrolVat, Double dieselVat) {
        this.startDate = startDate;
        this.petrolPumpPrice = petrolPumpPrice;
        this.dieselPumpPrice = dieselPumpPrice;
        this.petrolDutyPrice = petrolDutyPrice;
        this.dieselDutyPrice = dieselDutyPrice;
        this.petrolVat = petrolVat;
        this.dieselVat = dieselVat;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Double getPetrolPumpPrice() {
        return petrolPumpPrice;
    }

    public Double getDieselPumpPrice() {
        return dieselPumpPrice;
    }

    public Double getPetrolDutyPrice() {
        return petrolDutyPrice;
    }

    public Double getDieselDutyPrice() {
        return dieselDutyPrice;
    }

    public Double getPetrolVat() {
        return petrolVat;
    }

    public Double getDieselVat() {
        return dieselVat;
    }

    @Override
    public String toString() {
        return "Fuel{" +
                "startDate=" + startDate +
                ", petrolPumpPrice=" + petrolPumpPrice +
                ", dieselPumpPrice=" + dieselPumpPrice +
                ", petrolDutyPrice=" + petrolDutyPrice +
                ", dieselDutyPrice=" + dieselDutyPrice +
                ", petrolVat=" + petrolVat +
                ", dieselVat=" + dieselVat +
                '}';
    }
}
