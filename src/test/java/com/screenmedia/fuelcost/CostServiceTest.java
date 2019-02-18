package com.screenmedia.fuelcost;

import com.screenmedia.fuelcost.model.Cost;
import com.screenmedia.fuelcost.persistence.Fuel;
import com.screenmedia.fuelcost.persistence.FuelRepository;
import com.screenmedia.fuelcost.services.CostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CostServiceTest {
    @Mock
    FuelRepository fuelRepository;

    @Autowired
    CostService costService;

    @Test
    public void testCaluclateDifferenceMethod() {
        Fuel fuel = new Fuel(LocalDate.of(2003, 9, 15), 102D, 106.32D, 57.95D, 57.95D, 20D, 20D);


        Mockito.when(fuelRepository.findTop1ByStartDateBeforeOrderByStartDateDesc(LocalDate.of(2003, 9, 15))).thenReturn(fuel);
        Cost cost = costService.calculateJourneyCost(LocalDate.of(2003, 9, 15), "ulsp", 25D, 100D);
        assertEquals(cost.getTotalJourneyCost(), Double.valueOf(11.54));
    }
}
