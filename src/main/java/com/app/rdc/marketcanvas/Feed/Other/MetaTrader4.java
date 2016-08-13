/**
 * Market canvas display application
 *
 * @author  Ronald Partridge
 * @version 0.1
 * @since   2016-07-29
 */

package com.app.rdc.marketcanvas.Feed.Other;

import com.app.rdc.marketcanvas.World.MarketBlock;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MetaTrader4 {

    private DateFormat MT4CSVDateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm");

    public List<MarketBlock> OpenFromDisk(String csvFile) {
        List<MarketBlock> blocks = new ArrayList();

        try {
            CSVParser parser = new CSVParser(new FileReader(csvFile), CSVFormat.DEFAULT);

            Date parsedDate;

            for(CSVRecord r : parser) {
                String dateAndTime = r.get(0) + " " + r.get(1);
                parsedDate =  MT4CSVDateFormat.parse(dateAndTime);

                MarketBlock b = new MarketBlock();
                b.setTimeStamp(parsedDate);
                b.setPriceOpen(Float.parseFloat(r.get(2)));
                b.setPriceHigh(Float.parseFloat(r.get(3)));
                b.setPriceLow(Float.parseFloat(r.get(4)));
                b.setPriceClose(Float.parseFloat(r.get(5)));
                b.setVolume(Integer.parseInt(r.get(6)));

                blocks.add(b);
            }

        } catch(IOException|ParseException ex) {

        }

        return blocks;
    }
}
