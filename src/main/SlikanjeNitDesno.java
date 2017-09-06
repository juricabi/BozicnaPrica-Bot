package main;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Predstavlja nit koja služi za zauzimanje sjedala èije su "koordinate"
 * generirane sluèajnim brojevima.
 * 
 * @author Aleksander
 *
 */
public class SlikanjeNitDesno implements Runnable {

    public SlikanjeNitDesno() {
    }

    @Override
    public void run() {
	while (true) {

	    try {
		Robot robot = new Robot();
		Rectangle Slika = new Rectangle(1330, 845, 108, 108);
		while (true) {
		    BufferedImage screenShot = robot.createScreenCapture(Slika);

		    if (screenShot.getRGB(50, 75) > -400000) {
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyRelease(KeyEvent.VK_RIGHT);
			Thread.sleep(20);
		    }

		}

	    } catch (Exception e) {
		// TODO: handle exception
	    }

	}

    }

}
