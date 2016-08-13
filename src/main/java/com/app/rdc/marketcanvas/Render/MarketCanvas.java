/**
 * Market canvas display application
 *
 * @author  Ronald Partridge
 * @version 0.1
 * @since   2016-07-29
 */

package com.app.rdc.marketcanvas.Render;

import com.app.rdc.marketcanvas.World.MarketBlock;
import com.app.rdc.marketcanvas.World.World;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MarketCanvas extends Canvas {

    /*
     * Copy MT4's crappy zoom (4 levels) 72DPI
     */

    int canvasWidth = 1024;
    int canvasHeight = 768;

    private boolean isRefreshed = false;
    private GraphicsContext gc;

    public MarketCanvas() {

        super();

        this.setWidth(canvasWidth);
        this.setHeight(canvasHeight);

        this.gc = this.getGraphicsContext2D();

        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    public void render(World w) {

        if(isRefreshed)
            return;

        // Render 10 bars for now

        //for(MarketBlock mb : w.getBlocks()) {

        //}

        int lineWidth = 5;
        int spacing = 5;

        gc.setStroke(Color.GREEN);
        gc.setLineWidth(lineWidth);

        for(int i = 0; i < 20; i++) {
            // gc.strokeLine(100 + (i * lineWidth), 300, 100 + (i * lineWidth), 400);
            // gc.strokeLine(100 + (i * lineWidth), 300, 100 + (i * lineWidth), 400);
            gc.strokeLine(100 + ((spacing + lineWidth) * i), 300, 100 + ((spacing + lineWidth) * i), 400);
        }

        //gc.strokeLine(100, 300, 100, 400);

        //gc.strokeLine(100 + spacing + lineWidth, 300, 100 + spacing + lineWidth, 400);

    }
}
