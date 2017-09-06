package main;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class SlikanjeNitLijevo implements Runnable {

    public SlikanjeNitLijevo() {

    }

    @Override
    public void run() {
	try {
	    Robot robot = new Robot();
	    Rectangle Slika = new Rectangle(480, 845, 108, 108);
	    while (true) {
		BufferedImage screenShot = robot.createScreenCapture(Slika);
		if (screenShot.getRGB(50, 75) > -400000) {
		    robot.keyPress(KeyEvent.VK_LEFT);
		    robot.keyRelease(KeyEvent.VK_LEFT);
		    Thread.sleep(20);
		}

	    }

	} catch (Exception e) {
	    // TODO: handle exception
	}

    }

}
