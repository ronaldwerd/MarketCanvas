package com.app.rdc.marketcanvas.World;

// import lombok;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class MarketBlock {
    private float priceHigh;
    private float priceLow;
    private float priceClose;
    private int timeStamp;
}
