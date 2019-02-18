package com.screenmedia.fuelcost.persistence;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.screenmedia.fuelcost.constants.Constants;
import com.screenmedia.fuelcost.utils.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;

@Component
public class FuelCommandLineRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory
            .getLogger(FuelCommandLineRunner.class);

    @Autowired
    private FuelRepository fuelRepository;
    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public void run(String... args) throws Exception {
        Resource resource = resourceLoader.getResource(Constants.CSV_FILE_PATH);
        Fuel fuel = null;
        try {

            Reader reader = new InputStreamReader(resource.getInputStream());
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(Constants.THREE).build();

            String[] record;
            while ((record = csvReader.readNext()) != null) {
                fuel = new Fuel((LocalDate.parse(record[Constants.DATE], Util.formatter)),
                        Double.valueOf(record[Constants.ULSP_PUMP_PRICE]),
                        Double.valueOf(record[Constants.ULSD_PUMP_PRICE]),
                        Double.valueOf(record[Constants.ULSP_DUTY_PRICE]),
                        Double.valueOf(record[Constants.ULSD_DUTY_PRICE]),
                        Double.valueOf(record[Constants.ULSP_VAT_RATE]),
                        Double.valueOf(record[Constants.ULSD_VAT_RATE]));
                fuelRepository.save(fuel);
            }

        }catch (IOException e) {
            if(null != fuel) {
                log.error("Failed persisting fuel object" + fuel.toString() + e);
            }else {
                log.error("Failed persisting fuel object" + e);
            }
        }
    }
}
