/**
 * World information contains all chart objects in a price/time space
 *
 * @author  Ronald Partridge
 * @version 0.1
 * @since   2016-07-29
 */

package com.app.rdc.marketcanvas.World;

import java.util.List;

public class World {

    private int timeFrame;
    private List<MarketBlock> blocks;

    public World(int timeFrame) {
        this.timeFrame = timeFrame;
    }
}
