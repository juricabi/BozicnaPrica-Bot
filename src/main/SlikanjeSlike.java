package main;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class SlikanjeSlike implements Runnable {

    public SlikanjeSlike() {

    }

    @Override
    public void run() {
	Rectangle rect = new Rectangle(530, 800, 860, 110);
	try {
	    Robot robot = new Robot();

	    while (true) {
		// System.out.println(BotHelper.Y);
		BufferedImage img = robot.createScreenCapture(rect);
		if (img.getRGB(BotHelper.LijevoX, BotHelper.Y) > -400000) {
		    robot.keyPress(KeyEvent.VK_LEFT);
		    robot.keyRelease(KeyEvent.VK_LEFT);
		    Thread.sleep(25);
		} else if (img.getRGB(BotHelper.DesnoX, BotHelper.Y) > -400000) {
		    robot.keyPress(KeyEvent.VK_RIGHT);
		    robot.keyRelease(KeyEvent.VK_RIGHT);
		    Thread.sleep(25);
		}
	    }
	} catch (Exception e) {
	}
    }

}
