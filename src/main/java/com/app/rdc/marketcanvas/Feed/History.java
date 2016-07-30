package com.app.rdc.marketcanvas.Feed;

import com.app.rdc.marketcanvas.World.MarketBlock;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ronald on 7/29/2016.
 */
public class History {

    public List<MarketBlock> OpenFromDisk(String csvFile) {
        List<MarketBlock> blocks = new ArrayList();

        try {
            CSVParser parser = new CSVParser(new FileReader(csvFile), CSVFormat.DEFAULT);
        } catch(IOException ex) {

        }

        return blocks;
    }
}
