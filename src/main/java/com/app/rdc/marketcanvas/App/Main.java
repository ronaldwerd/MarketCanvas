/**
 * Market canvas display application
 *
 * @author  Ronald Partridge
 * @version 0.1
 * @since   2016-07-29
 */

package com.app.rdc.marketcanvas.App;

import com.app.rdc.marketcanvas.Feed.Other.MetaTrader4;
import com.app.rdc.marketcanvas.Render.MarketCanvas;
import com.app.rdc.marketcanvas.World.MarketBlock;
import com.app.rdc.marketcanvas.World.World;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.List;


public class Main extends Application {

    private int shadowSize = 20;

    private Settings settings;
    private MarketCanvas marketCanvas;


    @Override public void start(final Stage primaryStage) {

        settings = Settings.getInstance();
        marketCanvas = new MarketCanvas();

        primaryStage.setWidth(settings.APP_WIDTH);
        primaryStage.setHeight(settings.APP_HEIGHT);
        Scene scene = new Scene(new Group());

        VBox root = new VBox();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPannable(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);


        scrollPane.setContent(marketCanvas);

        root.getChildren().addAll(scrollPane);
        scene.setRoot(root);

        primaryStage.setScene(scene);
        primaryStage.show();

        MetaTrader4 history = new MetaTrader4();
        List<MarketBlock> blocks = history.OpenFromDisk("support/GBPUSD60.csv");

        World world = new World(60);
        world.setBlocks(blocks);
        marketCanvas.render(world);
    }
    
    private Pane createShadowPane() {
        Pane shadowPane = new Pane();
        // a "real" app would do this in a CSS stylesheet.

        shadowPane.setStyle(
                "-fx-background-color: white;" +
                        "-fx-effect: dropshadow(gaussian, black, " + shadowSize + ", 0, 0, 0);" +
                        "-fx-background-insets: " + shadowSize + ";");

        Rectangle innerRect = new Rectangle();
        Rectangle outerRect = new Rectangle();
        shadowPane.layoutBoundsProperty().addListener(
                (observable, oldBounds, newBounds) -> {
                    innerRect.relocate(
                            newBounds.getMinX() + shadowSize,
                            newBounds.getMinY() + shadowSize
                    );
                    innerRect.setWidth(newBounds.getWidth() - shadowSize * 2);
                    innerRect.setHeight(newBounds.getHeight() - shadowSize * 2);

                    outerRect.setWidth(newBounds.getWidth());
                    outerRect.setHeight(newBounds.getHeight());

                    Shape clip = Shape.subtract(outerRect, innerRect);
                    shadowPane.setClip(clip);
                }
        );

        return shadowPane;
    }

    /*
     * Hack a quick world together
     */


    public static void main(String[] args) {
        launch(args);
    }
}
