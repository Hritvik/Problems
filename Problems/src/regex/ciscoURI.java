package regex;

public class ciscoURI {

	public static void main(String[] args) {
		String[] number = new String[1];
		number[0] = "tel: +1-800-234-5678;cic=2345";
		number[1] = "sip: +1-800-234-5678@cic=2345";
		solver(number);
	}

	private static void solver(String[] number) {
		String result = null;
		for (int i = 0; i < number.length; i++) {
			String str = number[i];
			result = str.split("\\+")[1].trim().split("\\;")[0];
			System.out.println("|" + number[i] + "| ==>> |" + result + "|");
		}

	}
}
