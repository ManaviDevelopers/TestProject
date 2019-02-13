/*
 * 
 */
package demo;

import java.awt.Robot;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Test.
 */
public class Test {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random d = new Random();

		while (true) {
			try {
				int i = d.nextInt(1350);
				Robot r = new Robot();
				// System.out.println(i);
				r.mouseMove(i, i);
				Thread.sleep(5000l);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
