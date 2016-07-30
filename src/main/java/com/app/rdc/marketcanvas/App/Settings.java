/**
 * Market canvas display application
 *
 * @author  Ronald Partridge
 * @version 0.1
 * @since   2016-07-29
 */

package com.app.rdc.marketcanvas.App;

public class Settings {

    private static Settings instance = null;

    public int APP_WIDTH = 800;
    public int APP_HEIGHT = 600;

    public String APP_NAME = "Market Canvas";

    public int DEFAULT_TF = 3;

    protected Settings() {

        /*
         * Provides default settings for the application.
         */
    }

    public static Settings getInstance() {

        if(instance == null) {
            instance = new Settings();
        }

        return instance;
    }
}
