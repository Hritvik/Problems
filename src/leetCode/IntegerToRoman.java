package leetCode;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
	public static void main(String[] args) {
		System.out.println(new IntegerToRoman().intToRoman(10));
	}

	public String intToRoman(int num) {
		String output = "";
		Map<Integer, String> symbols = new HashMap<>();
		symbols.put(1, "I");
		symbols.put(2, "II");
		symbols.put(3, "III");
		symbols.put(4, "IV");
		symbols.put(5, "V");
		symbols.put(6, "VI");
		symbols.put(7, "VII");
		symbols.put(8, "VIII");
		symbols.put(9, "IX");
		symbols.put(10, "X");
		symbols.put(40, "XL");
		symbols.put(50, "L");
		symbols.put(90, "XC");
		symbols.put(100, "C");
		symbols.put(400, "CD");
		symbols.put(500, "D");
		symbols.put(900, "CM");
		symbols.put(1000, "M");

		String digits = "" + num;
		for (int i = digits.length() - 1; i >= 0; i--) {
			int y = digits.charAt(i) - '0';
			if (y == 0) {
				continue;
			}
			int x = (y) * ((int) Math.pow(10, digits.length() - 1 - i));
//			System.out.println(y + " :: " + x);
			if (symbols.containsKey(x)) {
				output = symbols.get(x) + output;
			} else if (x > 10 && x < 50) {
				String temp = "";
				String c = "X";
				int p = x / 10;
				for (int j = 0; j < p; j++) {
					temp += c;
				}
				output = temp + output;
			} else if (x > 50 && x < 100) {
				String temp = "L";
				String c = "X";
				int p = x / 10 - 5;
				for (int j = 0; j < p; j++) {
					temp += c;
				}
				output = temp + output;
			} else if (x > 100 && x < 500) {
				String temp = "";
				String c = "C";
				int p = x / 100;
				for (int j = 0; j < p; j++) {
					temp += c;
				}
				output = temp + output;
			} else if (x > 500 && x < 1000) {
				String temp = "D";
				String c = "C";
				int p = x / 100 - 5;
				for (int j = 0; j < p; j++) {
					temp += c;
				}
				output = temp + output;
			} else if (x > 1000 && x < 4000) {
				String temp = "";
				String c = "M";
				int p = x / 1000;
				for (int j = 0; j < p; j++) {
					temp += c;
				}
				output = temp + output;
			} else {
				output = symbols.get(y) + output;
			}
		}
		return output;
	}
}