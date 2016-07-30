/**
 * World information contains all chart objects in a price/time space
 *
 * @author  Ronald Partridge
 * @version 0.1
 * @since   2016-07-29
 */

package com.app.rdc.marketcanvas.World;

import lombok.Getter;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class World {

    private int timeFrame;
    private float priceMin;
    private float priceMax;
    private Date timeStart;
    private Date timeEnd;

    @Getter
    private List<MarketBlock> blocks;

    public void setBlocks(List<MarketBlock> blocks) {
        this.blocks = blocks;

        priceMin = Collections.min(blocks, Comparator.comparing(m -> m.getPriceHigh())).getPriceLow();
        priceMax = Collections.max(blocks, Comparator.comparing(m -> m.getPriceLow())).getPriceHigh();

        timeStart = blocks.get(0).getTimeStamp();
        timeEnd = blocks.get(blocks.size() - 1 ).getTimeStamp();
    }

    public World(int timeFrame) {
        this.timeFrame = timeFrame;
    }
}
