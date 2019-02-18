package com.screenmedia.fuelcost.persistence;


import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface FuelRepository extends CrudRepository<Fuel, Long> {

    Fuel findTop1ByStartDateBeforeOrderByStartDateDesc(LocalDate startDate);

}
