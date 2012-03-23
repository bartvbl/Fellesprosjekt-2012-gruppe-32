/*
 * CalendarApp.java
 */

package fp.views;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

import fp.core.ClientMain;


/**
 * The main class of the application.
 */
public class CalendarApp extends SingleFrameApplication {

    private static CalendarView calendarView;
	private static LoginScreen loginScreen;

	/**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        calendarView = new CalendarView(this);
        loginScreen = new LoginScreen();
        show(loginScreen);
        new ClientMain();
    }
    
    public void showMainWindow() {
    	show(calendarView);
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of CalendarApp
     */
    public static CalendarApp getApplication() {
        return Application.getInstance(CalendarApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(CalendarApp.class, args);
    }
}
