package day3;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/*code to generate ArithmeticException */
		try {
		    int i = 10 / 0;
		} catch (ArithmeticException e) {
		    System.out.println("Arithmetic Exception "+e.getMessage());
		}
		
		/*code to generate ArithmeticException */
		try {
			int[] array = new int[5];
			int boom = array[10];
		} catch (ArrayIndexOutOfBoundsException e) {
		    System.out.println("ArrayIndex Out Of Bounds Exception "+e.getMessage());
		}
		
		/*code to generate FilenotfoundException */
		
		try {
			File file=new File("lines.txt");
            Scanner scan=new Scanner(file);
		} catch (Exception e) {
		    System.out.println("File Not Found "+e.getMessage());
		}
		
		
	}

}
