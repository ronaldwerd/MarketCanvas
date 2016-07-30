package com.app.rdc.marketcanvas.World;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MarketBlock {
    private float priceOpen;
    private float priceHigh;
    private float priceLow;
    private float priceClose;
    private int volume;
    private Date timeStamp;
}
