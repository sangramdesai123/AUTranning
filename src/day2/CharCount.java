package day2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		String s = in.nextLine();
		System.out.println(s);

		Map<Character, Integer> hm = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (hm.containsKey(c)) {
				hm.put(c, hm.get(c) + 1);
			}

			else {
				hm.put(c, 1);
			}
		}
		System.out.println(hm);

		
	}

}
