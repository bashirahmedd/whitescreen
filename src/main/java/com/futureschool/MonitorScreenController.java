package com.futureschool;

import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
import java.awt.Window;

public class MonitorScreenController {

    GraphicsDevice[] devices;

    public MonitorScreenController() {
        GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        devices = g.getScreenDevices();

        for (int i = 0; i < devices.length; i++) {
            GraphicsDevice gd = devices[i];
            System.out.println(gd.getIDstring());
            System.out.println("Width:" + gd.getDisplayMode().getWidth());
            System.out.println("Height:" + gd.getDisplayMode().getHeight());
        }
    }

    public Window getTargetMonitor() {
        if (devices.length > 1) {
            return devices[1].getFullScreenWindow();
        }
        return devices[0].getFullScreenWindow();
    }

}
