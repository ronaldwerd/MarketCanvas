/**
 * Market canvas display application
 *
 * @author  Ronald Partridge
 * @version 0.1
 * @since   2016-07-29
 */

package com.app.rdc.marketcanvas.App;

import com.app.rdc.marketcanvas.Feed.History;
import com.app.rdc.marketcanvas.World.MarketBlock;
import com.app.rdc.marketcanvas.World.World;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.List;

public class Main extends Application {

    private int shadowSize = 20;

    private void drawShapes(GraphicsContext gc) {

        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);

        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);

        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);

        gc.fillPolygon(new double[]{10, 40, 10, 40}, new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90}, new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140}, new double[]{210, 210, 240, 240}, 4);
    }

    @Override public void start(final Stage stage) {
        Settings s = Settings.getInstance();

        stage.setTitle(s.APP_NAME);
        stage.setResizable(true);
        stage.initStyle(StageStyle.TRANSPARENT);

        StackPane stackPane = new StackPane(createShadowPane());
        stackPane.setStyle(
                "-fx-background-color: rgba(255, 255, 255, 0.5);" +
                        "-fx-background-insets: " + shadowSize + ";"
        );


        Scene scene = new Scene(stackPane, s.APP_WIDTH, s.APP_HEIGHT);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);

        Canvas canvas = new Canvas(s.APP_WIDTH - 7 - shadowSize, s.APP_HEIGHT - 7 - shadowSize);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //drawShapes(gc);

        stackPane.getChildren().add(canvas);


        //Group root = new Group();
        //root.getChildren().add(canvas);
        //stage.setScene(new Scene(root));


        // new Scene()
        //Canvas canvas = new Canvas(s.APP_WIDTH, s.APP_HEIGHT);

        // GraphicsContext gc = scene.getGraphicsContext2D();

        stage.show();

        /*
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
         */

        demonstrate();
    }

    /*
    @Override
    public void start(Stage primaryStage) throws Exception{
        Settings s = Settings.getInstance();


        StackPane stackPane = new StackPane();

        stackPane.setStyle(
                "-fx-background-color: rgba(255, 255, 255, 0.5);" +
                        "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);" +
                        "-fx-background-insets: 50;"
        );

        Scene scene = new Scene(stackPane, s.APP_WIDTH, s.APP_HEIGHT);
        scene.setFill(Color.TRANSPARENT);

        primaryStage.setTitle(s.APP_NAME);
        primaryStage.setScene(scene);

        // primaryStage.setS

        // Group root = new Group();
        // Canvas canvas = new Canvas(s.APP_WIDTH, s.APP_HEIGHT);


        //canvas.set

        //GraphicsContext gc = canvas.getGraphicsContext2D();
        //gc.setFill(Color.BLACK);

        //drawShapes(gc);

        // root.getChildren().add(canvas);
        // primaryStage.setScene(new Scene(root));
        // primaryStage.show();

        //primaryStage.setScene(new Scene(root, s.APP_WIDTH, s.APP_HEIGHT));
        primaryStage.show();
    }
    */

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

    private void demonstrate() {
        History history = new History();
        List<MarketBlock> blocks = history.OpenFromDisk("support/GBPUSD60.csv");

        World world = new World(60);
        world.setBlocks(blocks);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
