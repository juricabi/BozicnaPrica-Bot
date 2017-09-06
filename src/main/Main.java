package main;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws Exception {

	ExecutorService executorServiceZauzimanje = Executors.newFixedThreadPool(1);
	// executorServiceZauzimanje.execute(new SlikanjeSlike());
	executorServiceZauzimanje.execute(new BotHelper());

	Rectangle rect = new Rectangle(530, 800, 860, 110);
	int usporedba = -1900000;
	int vrijemeSna = 30;
	try {
	    Robot robot = new Robot();

	    while (true) {
		if (BotHelper.predKraj) {
		    usporedba = -2000000;
		    vrijemeSna = 17;
		} else {
		    usporedba = -1900000;
		    vrijemeSna = 30;
		}
		BufferedImage img = robot.createScreenCapture(rect);

		if (img.getRGB(BotHelper.LijevoX, BotHelper.Y) > usporedba) {

		    robot.keyPress(KeyEvent.VK_LEFT);
		    robot.keyRelease(KeyEvent.VK_LEFT);
		    Thread.sleep(vrijemeSna);

		} else if (img.getRGB(BotHelper.DesnoX, BotHelper.Y) > usporedba) {

		    robot.keyPress(KeyEvent.VK_RIGHT);
		    robot.keyRelease(KeyEvent.VK_RIGHT);
		    Thread.sleep(vrijemeSna);
		}
	    }
	} catch (Exception e) {
	}
    }

}