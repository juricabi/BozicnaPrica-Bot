package main;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

public class BotHelper implements Runnable {
    public static int Y = 109;
    public static int LijevoX = 12;
    public static int DesnoX = 848;
    public static int PrvaLampicaX = 690;
    public static int PrvaLampicaY = 460;
    public static int DrugaLampicaX = 1200;
    public static int DrugaLampicaY = 420;
    public static int TrecaLampicaX = 1250;
    public static int TrecaLampicaY = 730;
    public static boolean predKraj = false;

    @Override
    public void run() {
	Rectangle rect = new Rectangle(0, 0, 1920, 1080);
	try {
	    Robot robot = new Robot();
	    while (true) {
		// System.out.println("Test");
		BufferedImage img = robot.createScreenCapture(rect);
		// System.out.println(img.getRGB(PrvaLampicaX, PrvaLampicaY));

		if (img.getRGB(PrvaLampicaX, PrvaLampicaY) > -400000
			&& img.getRGB(DrugaLampicaX, DrugaLampicaY) > -400000
			&& img.getRGB(TrecaLampicaX, TrecaLampicaY) > -400000) {
		    Y = 76;
		    predKraj = true;
		}

		else if (img.getRGB(PrvaLampicaX, PrvaLampicaY) > -400000
			&& img.getRGB(DrugaLampicaX, DrugaLampicaY) > -400000) {
		    Y = 80;
		    predKraj = false;

		} else if (img.getRGB(PrvaLampicaX, PrvaLampicaY) > -400000) {
		    Y = 87;
		    predKraj = false;
		}

		else
		    Y = 109;

		Thread.sleep(250);
	    }

	} catch (Exception e) {
	    // TODO: handle exception
	}

    }
}
