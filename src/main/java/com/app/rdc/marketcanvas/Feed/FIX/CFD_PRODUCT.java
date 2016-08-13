package com.app.rdc.marketcanvas.Feed.FIX;

/**
 * Created by Ronald on 8/1/2016.
 */
public enum CFD_PRODUCT {
    GBPUSD(2), USDCAD(8);

    private int symbol;

    CFD_PRODUCT(int symbol) {
        this.symbol = symbol;
    }
}